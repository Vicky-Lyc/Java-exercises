package com.example.week6.model;

import com.example.week6.Dog;
import com.example.week6.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ELServlet", value = "/el")
public class ELServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        Dog dog = new Dog("Bob");
        request.setAttribute("dog", dog);
        Person person = new Person("Jay", dog);
        request.setAttribute("person", person);
        Map<String, String> map = new HashMap<>();
        map.put("shanghai", "CN"); map.put("london", "UK");
        request.setAttribute("city", map);
        request.setAttribute("balance", 100);
        request.getRequestDispatcher("el-result.jsp").forward(request, response);
    }
}