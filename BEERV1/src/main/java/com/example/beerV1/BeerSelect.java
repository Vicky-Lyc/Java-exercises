package com.example.beerV1;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "Ch3 Beer",value ="/SelectBeer.do")
public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result =be.getBeer(c);

        request.setAttribute("styles",result);

        RequestDispatcher view =
                request.getRequestDispatcher("result.jsp");

        view.forward(request,response);
    }
}