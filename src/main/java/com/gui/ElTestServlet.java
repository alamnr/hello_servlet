package com.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import com.bean.Dog;
import com.bean.Employee;
import com.bean.Person;
import com.bean.Toy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns =  "/elTest")
public class ElTestServlet extends HttpServlet{

    private static Log log = LogFactory.getLog(ElTestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //String name = req.getParameter("userName");
        //req.setAttribute("name", name);

        //Person p = new Employee();
        //p.setName("Evan");
        //req.setAttribute("person", p);

        Employee emp = new Employee();
        emp.setName("Chodon lal");
        emp.setEmpId(55);
        Dog dog = new Dog();
        dog.setName("Tom");
        emp.setDog(dog);

        req.setAttribute("person", emp);

        ArrayList nums = new ArrayList<>();
        nums.add("1");
        nums.add("2");
        nums.add("3");

        req.setAttribute("numbers", nums);

        String[] favoriteMusic = {"Zero 7","Tahiti 80","BT","Frou Frou"} ;
        req.setAttribute("musicList", favoriteMusic);

        Employee emp_1 = new Employee();
        emp_1.setName("Leelu"); 
        Dog d = new Dog();
        d.setName("Tom");
        Toy t1 = new Toy();
        t1.setName("Toy-1");
        Toy t2 = new Toy();
        t2.setName("Toy-2");
        Toy t3 = new Toy();
        t3.setName("Toy-3");
        d.setToys(new Toy[]{t1,t2,t3});
        emp_1.setDog(d);
        req.setAttribute("employee", emp_1);
        RequestDispatcher view = req.getRequestDispatcher("/jsp/result.jsp");
        view.forward(req, resp);
    }
    
}
