package com.async;

import java.io.IOException;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true,urlPatterns = "/async1")
public class Async1 extends HttpServlet {

  
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(Async1.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext actx = req.startAsync();
        actx.setTimeout(30*1000);
        actx.start(()->{
            try {
                String path = "/jsp/async/async1.jsp";
                Thread.currentThread().setName("Async1-Thread");
                log.info("Putting Asyncthread to sleep");
                Thread.sleep(2*1000);
                log.info("Dispatching to " + path);
                actx.dispatch(path);
            } catch (InterruptedException ex) {
                log.error("Async1",ex);
            } catch(IllegalStateException ex){
                log.error("Async1",ex);
            }
        });
    }
    
}
