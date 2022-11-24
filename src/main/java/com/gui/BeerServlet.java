package com.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/beer/selectBeer"})
public class BeerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<String> colorList = new ArrayList<>();
       String[] colors = {"light","amber","brown","dark"};
       colorList = Arrays.asList(colors);
       req.getServletContext().setAttribute("colorList", colorList);
       RequestDispatcher rd = req.getRequestDispatcher("/jsp/beer.jsp");
       rd.forward(req, resp);
    }


    
}
