package com.koreait.servlet_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/*
* num1과 num2를 calculatorServlet에 전달해서
두 숫자의 합을 화면에 출력하라.
출력해야하는 형태: "?(num1의값) + ?(num2의값) = ?(합계 값)"
만약, 계산시 오류가 발생했다면, calculatorErrorServlet로 이동해서 화면에 "오류가 발생했습니다" 를 출력하도록 구성하라.
*
* */
@WebServlet("/calc_error")
public class CalculatorErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("오류가 발생했습니다");
    }
}
