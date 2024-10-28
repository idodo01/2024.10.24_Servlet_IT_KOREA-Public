package com.koreait.servlet_project.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie_req")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("my_cookie1", "test!");
        Cookie cookie2 = new Cookie("my_cookie2", "안녕!");
        cookie2.setPath("/first");
        // maxAge를 사용하지 않거나 음수를 사용하면 Session쿠키로 만들어진다
        // => 파일로 만들어지지않음 && 브라우저 끄면 사라짐
        cookie2.setMaxAge(30); // 30초만 파일로 존재하는 Persistence 쿠키로 만들 것이다.
        // 내가 생성한 쿠키값을 브라우저에 응답으로 보내면, 브라우저는 해당 쿠키를 파일로 저장한다
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
