package com.koreait.servlet_project.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebServlet("/listen/req")
//public class RequestServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("listener Servlet 실행");
//        HttpSession session = req.getSession();
//        session.setAttribute("username", "test");
//        session.removeAttribute("username");
//    }
//}

@WebServlet("/listen/enterence")
public class RequestServlet extends HttpServlet {
    private ServletContext context;

    @Override
    public void init() throws ServletException {
        this.context = getServletContext();
        this.context.setAttribute("peopleCount", 0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("listener Servlet 실행1111");
        int peopleCount = Integer.parseInt(String.valueOf(context.getAttribute("peopleCount"))) + 1;
        resp.getWriter().write("<b>" + peopleCount + "</b>명");

    }
}

