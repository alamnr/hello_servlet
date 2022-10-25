package com.gui;

import java.io.IOException;
import java.io.PrintWriter;

import com.util.HTMLFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestParamExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Request Parameter Example</title></head><body><h3>Request Parameter Example</h3>");
        out.println("Parameter in this request : <br>");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if(firstName != null || lastName !=null)
        {
            out.println("First Name  ");
            out.println(" = "+ HTMLFilter.filter(firstName));
            out.println("Last Name ");
            out.println(" = "+ HTMLFilter.filter(lastName));
        } else {
            out.println("No Parameters, please enter some");
        }

        out.println("<p>");
        out.println("<form action=/hello_servlet/requestParam  method=post>");
        out.println(" First Name : ");
        out.println("<input type=text size=20 name=firstName>");
        out.println("<br>");
        out.println("Last Name: ");
        out.println("<input type=text size=20 name=lastName>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
    
}
