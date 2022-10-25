package com.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestHeaderExample extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Enumeration enumeration = req.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = (String)enumeration.nextElement();
            String value = req.getHeader(name);
            out.println(name + " = " +value);
        }

    }


    
}
