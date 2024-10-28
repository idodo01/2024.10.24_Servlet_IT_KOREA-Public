package com.koreait.servlet_project.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/cookie_res")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        // 해당 도메인에 쿠키값은 여러 개가 있을 수 있으므로, 모든 쿠키값을 배열로 가져옵니다.
        Cookie[] cookies = req.getCookies();
        // 쿠키가 하나도 없는 상태라면, cookies는 null이기 때문에 null이 아닐 때만 출력합니다
        if(cookies != null) {
            // 가져온 모든 쿠키의 이름과 값을 화면에 출력하기
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                out.println("cookieName => " + cookieName);
                out.println("cookieValue => " + cookieValue);
                System.out.println(cookieValue);
                out.println("<br>");
            }
        }
        else{
            out.println("쿠키가 존재하지 않습니다.");
        }

    }
}
