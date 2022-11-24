package com.filter;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BeerRequestFilter implements Filter {

    private FilterConfig filterConfig;
    private ServletContext sc;    
    private static Log log = LogFactory.getLog(BeerRequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig; 
        this.sc = filterConfig.getServletContext();   
    }

    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        HttpServletResponse httpServletResponse = (HttpServletResponse)res;

        String valid_encoding = httpServletRequest.getHeader("Accept-Encoding");
        if(valid_encoding.indexOf("gzip")>-1){
            CompressionResponseWrapper wrappedResponse = new CompressionResponseWrapper(httpServletResponse);
            wrappedResponse.setHeader("Content-Encoding", "gzip");

            String userName = httpServletRequest.getRemoteUser();
            if(userName != null){
                //filterConfig.getServletContext().log(userName + " is updating requests for " + httpServletRequest.getPathInfo());
                log.debug(userName + " is updating requests for " + httpServletRequest.getPathInfo());
               // System.out.println(userName + " is updating requests for " + httpServletRequest.getPathInfo());
            }
            filterChain.doFilter(httpServletRequest, wrappedResponse);

            GZIPOutputStream gzos = wrappedResponse.getGzipOutputStream();
            gzos.finish();
            sc.log(filterConfig.getFilterName() +" : finished the request");
        }
        else {
            sc.log(filterConfig.getFilterName() + " : no encoding performed");
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

       
    }
   
    @Override
    public void destroy() {
       sc = null;
       filterConfig = null;
    }  
    
}
