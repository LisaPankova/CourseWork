package ru.fantasy.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");

        PrintWriter writer = resp.getWriter();
        if (a != null && b != null) {
            int i = Integer.parseInt(a) + Integer.parseInt(b);
            writer.println(a + "+" + b + "=" + i);
        }else{
            writer.println("parameter = null");
        }
   //     super.doGet(req, resp);
        writer.close();
    }
}


