package com.koreait.servlet_project.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== ResponseServlet doGet ===");

        // 4. 데이터 받기
        String data = req.getParameter("data");
        System.out.println("[ResponseServlet] data를 받았습니다: " + data);
        resp.getWriter().write("[ResponseServlet] data를 받았습니다: " + data);
    }
}
