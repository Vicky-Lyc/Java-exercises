package com.example.week3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatchServlet", value = "/DispatchServlet")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        // Please refer to BeerV1 project to see how to dispatch request to JSP
        // both "ClientInfoServlet" and "/ClientInfoServlet" can work.
        RequestDispatcher view = request.getRequestDispatcher("/ClientInfoServlet");
        view.forward(request, response);
    }
}
