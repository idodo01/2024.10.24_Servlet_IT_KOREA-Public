package com.koreait.servlet_project.binding;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/bind_req")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestServlet doGet");

        System.out.println(getServletContext().getAttribute("init_data"));

        // setAttribute에서는 어떤 형태의 데이터라도 binding이 가능하다
        req.setAttribute("message", "나의 데이터^-^"); // 문자열
        req.setAttribute("number", 20); // 단순 숫자
        req.setAttribute("now", new Date()); // 현재 날짜와 시간 객체를 저장하기

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bind_res");
        dispatcher.forward(req, resp);

//        resp.sendRedirect("/bind_res");





    }
}
