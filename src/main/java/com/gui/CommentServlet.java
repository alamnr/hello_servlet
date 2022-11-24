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

@WebServlet(urlPatterns = {"/beer/addComment"})
public class CommentServlet extends HttpServlet {
    
    private static final Log log = LogFactory.getLog(CommentServlet.class) ;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<String> commentList = (ArrayList<String>) req.getServletContext().getAttribute("commentList");
       if(commentList !=null){
            commentList.add(req.getParameter("input"));
       }
       else{
        commentList = new ArrayList<String>();
        req.getServletContext().setAttribute("commentList", commentList);
       }
       log.info("commentList - "+ commentList);
       /* RequestDispatcher rd = req.getRequestDispatcher("/jsp/commentProcess.jsp");
       rd.forward(req, resp); */
       resp.sendRedirect(req.getContextPath()+"/jsp/commentProcess.jsp?userType="+req.getParameter("userType"));
    }
}
