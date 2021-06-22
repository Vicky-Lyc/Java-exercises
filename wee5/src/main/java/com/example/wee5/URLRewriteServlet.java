package com.example.wee5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "URLRewriteServlet", value = "/url-rewrite")
public class URLRewriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("a", 1);
        out.println("<html><body>");
        out.println("<a href=\"" + response.encodeURL("hello-servlet") + "\">click me</a>");
        out.println("</body></html>");
    }
}

