package com.koreait.servlet_project.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/session_res")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        // 세션 객체를 가져온다
        HttpSession session = req.getSession();
        out.println("session Id: " + session.getId() + "<br/>");
        out.println("created by: " + new Date(session.getCreationTime()) + "<br/>");
        out.println("interval time: " + session.getMaxInactiveInterval() + "<br/>");
        out.println("data: " + session.getAttribute("data") + "<br/>");
    }
}
