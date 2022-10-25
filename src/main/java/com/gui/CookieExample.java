package com.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import com.util.CookieFilter;
import com.util.HTMLFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CookieExample extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", req.getLocale());

        // Set cookie name

        String cookieName = req.getParameter("cookiename");
        String cookieValue = req.getParameter("cookievalue");
        Cookie aCookie = null;
        if(cookieName != null  && cookieValue != null ){
            if(!cookieName.isEmpty() && !cookieValue.isEmpty()){
                aCookie = new Cookie(cookieName, cookieValue);
                aCookie.setPath(req.getContextPath()+"/");
                resp.addCookie(aCookie);   
            }
            
        }        

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");

        String title = rb.getString("cookies.title");
        out.println("<title>"+title+"</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\" >");
        out.println("<h3>"+title+"</h3>");

        // Print cookiee
        Cookie[] cookies = req.getCookies();
        if(cookies!=null && cookies.length >0){
            HttpSession session = req.getSession(false);
            String sessionId = null;
            if(session !=null){
                sessionId = session.getId();
            }
            out.println(rb.getString("cookies.cookies")+"<br>");

            for (Cookie cookie : cookies) {
                String cName = cookie.getName();
                String cValue = cookie.getValue();
                out.print("Cookie Name: "+HTMLFilter.filter(cName)+"<br>");
                out.println("  Cookie Value: "
                + HTMLFilter.filter(CookieFilter.filter(cName, cValue, sessionId))
                + "<br><br>");
            }
        }  else {
            out.println(rb.getString("cookies.no-cookies"));
        }
        
        if (aCookie != null) {
            out.println("<P>");
            out.println(rb.getString("cookies.set") + "<br>");
            out.print(rb.getString("cookies.name") + "  "
                      + HTMLFilter.filter(cookieName) + "<br>");
            out.print(rb.getString("cookies.value") + "  "
                      + HTMLFilter.filter(cookieValue));
        }

        out.println("<P>");
        out.println(rb.getString("cookies.make-cookie") + "<br>");
        out.print("<form action=\"");
        out.println("./cookieExample\" method=POST>");
        out.print(rb.getString("cookies.name") + "  ");
        out.println("<input type=text length=20 name=cookiename><br>");
        out.print(rb.getString("cookies.value") + "  ");
        out.println("<input type=text length=20 name=cookievalue><br>");
        out.println("<input type=submit></form>");


        out.println("</body>");
        out.println("</html>");

        

    }


    
}
