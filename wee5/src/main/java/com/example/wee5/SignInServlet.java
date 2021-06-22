package com.example.wee5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        String name = req.getParameter("inputName");
        if(req.getSession().getAttribute("user")==null){
            if(name.equals("Vicky")){
                if (req.getParameter("password").equals("lyc123456")){
                    req.getSession().setAttribute("user",name);
                    resp.sendRedirect("index");
                }
                else{
                    req.getSession().setAttribute("user",null);
                    out.println("your password is incorrect");
                }

            }else if(name.equals("Lisa")){
                if (req.getParameter("password").equals("021212")){
                    req.getSession().setAttribute("user",name);
                    resp.sendRedirect("index");
                }
                else{
                    req.getSession().setAttribute("user",null);
                    out.println("your password is incorrect");
                }
            }else {
                req.getSession().setAttribute("user",name);
                resp.sendRedirect("index");
            }
        }
        else{
            resp.sendRedirect("index");
        }
    }
}
