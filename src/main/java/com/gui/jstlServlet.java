package com.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jstlForEach")
public class jstlServlet extends HttpServlet{

       private static Log log = LogFactory.getLog(jstlServlet.class);

       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String[] movies1 = {"Mov1-L1","Mov2-L1","Mov3-L1"};
           String[] movies2 = {"Mov1-L2","Mov2-L2","Mov3-L2"};
           List movieList = new ArrayList<>();
           movieList.add(movies1);
           movieList.add(movies2);
           req.setAttribute("movies", movieList);
           RequestDispatcher rd = req.getRequestDispatcher("/jsp/hello.jsp");
           rd.forward(req, resp);
       }
    
}
