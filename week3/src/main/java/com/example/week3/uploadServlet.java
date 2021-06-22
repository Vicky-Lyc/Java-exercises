package com.example.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {

        Part part=request.getPart("myfile");
        String filename=part.getName();
        String realPath= request.getServletContext().getRealPath("/upload/");
        System.out.println(realPath);
        part.write(realPath+filename);

    }
}
