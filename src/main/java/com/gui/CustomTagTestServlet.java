package com.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ctagtest"})
public class CustomTagTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List movieList = new ArrayList<>();
        movieList.add(new Movie("Tarjan","puck"));
        movieList.add(new Movie("Guddu","Hug"));
        movieList.add(new Movie("Kama","suck"));
        req.setAttribute("movieCollection", movieList);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/simpleCustomTag.jsp");
        rd.forward(req, resp);
    }
    
}
