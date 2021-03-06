package com.example.week6.model;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, String> userHobby;
    public List getList(String a){
        List<String> list = new ArrayList<>();
        list.add(a);
        return list;
    }
    @Override
    public void init() {
        userHobby = new HashMap<>();
        userHobby.put("Bob", "skiing");
        userHobby.put("Jim", "skiing");
        userHobby.put("James", "knitting");
        userHobby.put("Tom", "knitting");
        userHobby.put("Fei", "scuba");
        userHobby.put("Jone", "scuba");
        userHobby.put("Fred", "dating");
        userHobby.put("Pradeep", "dating");
        userHobby.put("Philippe", "dating");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hobby = request.getParameter("hobby");
        List<String> names = new ArrayList<>();
            userHobby.forEach((k, v) -> {
                if (v.equals(hobby)) {
                    names.add(k);
                }
            });
        request.setAttribute("names", names);
        request.setAttribute("hobby", hobby);
        // Two JSPs have different UI styles.
        //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
        request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}