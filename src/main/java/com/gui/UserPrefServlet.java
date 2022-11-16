package com.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/tester"})
public class UserPrefServlet extends HttpServlet {

    
    private static final Log log = LogFactory.getLog(UserPrefServlet.class) ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/userPreference.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userPref =  req.getParameter("userPref");
        if(userPref == null || userPref.isEmpty()){
            req.getSession().setAttribute("userPref", "");
        }else {
            req.getSession().setAttribute("userPref", userPref);
        }
        /* Map<String,String> eduMap= new HashMap();
        eduMap.put("sex","Female");
        req.getSession().setAttribute("eduMap",eduMap); */
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/userPrefResult.jsp");
        rd.forward(req, resp);
    }



    
}
