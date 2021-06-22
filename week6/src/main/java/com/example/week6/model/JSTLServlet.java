package com.example.week6.model;

import com.example.week6.Cat;
import com.example.week6.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JSTLServlet", value = "/jstl")
public class JSTLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users.add(new User(new Cat("Cat A", 3), 10));
        users.add(new User(new Cat("Cat B", 8), 19));
        users.add(new User(new Cat("Cat C", 5), 20));
        users.add(new User(new Cat("Cat D", 5), 15));

        request.setAttribute("users", users);

        request.setAttribute("user", "Admin");

        request.getRequestDispatcher("jstl-result.jsp").forward(request, response);


    }
}