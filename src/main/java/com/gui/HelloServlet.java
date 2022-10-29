package com.gui;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class HelloServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("a", "b");
       // req.setAttribute("a", "c");
        req.removeAttribute("a");
        
        //resp.setContentType("text/html");

        //PrintWriter out = resp.getWriter();
        //out.println("<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1></body></html");

        RequestDispatcher rd = req.getRequestDispatcher("cookieExample");
        rd.forward(req, resp);
    }
    
}