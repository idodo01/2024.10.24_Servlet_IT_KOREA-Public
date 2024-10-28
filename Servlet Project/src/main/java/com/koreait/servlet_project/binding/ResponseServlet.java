package com.koreait.servlet_project.binding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet("/bind_res")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseServlet doGet");
        String message = (String) req.getAttribute("message");
        int number = (Integer) req.getAttribute("number");
        Date now = (Date) req.getAttribute("now");

        System.out.println(message);
        System.out.println(number);
        System.out.println(now);



    }
}







