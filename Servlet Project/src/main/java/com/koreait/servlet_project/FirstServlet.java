package com.koreait.servlet_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 웹 요청을 받을 수 있는 클래스!
public class FirstServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("FirstServlet init");
    }

    // GET 요청을 받았을 때 자동 실행된다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet doGet 요청을 받았습니다");
    }
}
