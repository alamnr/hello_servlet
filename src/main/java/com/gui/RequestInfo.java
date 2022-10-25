package com.gui;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       PrintWriter writer = resp.getWriter();
       writer.println("<DOCTYPE!><html><head><title>Request Information Example</title></head><body><h3>Request  Information Example</h3>");
       writer.println("<p> Method : " + req.getMethod());
       writer.println("</p><p> Request URI :" + req.getRequestURI());
       writer.println("</p><p> Protocol : "+req.getProtocol());
       writer.println("</p><p> PathInfo : " +req.getPathInfo());
       writer.println("</p><p> Remote address : "+ req.getRemoteAddr());
       writer.println("</p> </body></html>");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}