package com.example.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "RedirectServlet", value = "/redirect")

public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int i = random.nextInt(10);
        if (i > 7) {
            response.sendRedirect("https://www.baidu.com");
        } else if (i > 4){
            response.sendRedirect("image");
        }
    }

}
