package com.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class HelloServlet  extends HttpServlet {

   
    private static final Log log = LogFactory.getLog(HelloServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*
        HttpSession session = req.getSession();
        if(session.isNew()){
            log.info("This is a new session - "+ session.getId());
        }
        else {
            log.info("Welcome back - "+ session.getId());

        }*/

        /* HttpSession session = req.getSession(false);
        if(session == null){
            log.info("no session was available, making one .....");
            session = req.getSession();
        }else {
            log.info("there was a session - "+ session.getId());

        }
 */
        //req.setAttribute("a", "b");
       // req.setAttribute("a", "c");
       // req.removeAttribute("a");
        
        //resp.setContentType("text/html");

        //PrintWriter out = resp.getWriter();
        //out.println("<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1></body></html");
        ArrayList<String> friends = new ArrayList<>(Arrays.asList("Fred","Pradeep","Philippe"));
        req.setAttribute("names", friends);
        RequestDispatcher rd = req.getRequestDispatcher("jsp/counter.jsp");
        rd.forward(req, resp); 
        

        /* resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        session.setAttribute("foo", "42"); */
       /*  session.setAttribute("bar", 420);
        session.invalidate();
        String foo = (String)session.getAttribute("foo");
        out.println("Foo - "+foo); */
       /*  session.setMaxInactiveInterval(0);
        String foo = (String)session.getAttribute("foo");
        if(session.isNew()){
            out.println("This is a new session");
        } else {
            out.println("Welcome back");
        }
        out.println("Foo - "+foo); */
    }
    
}