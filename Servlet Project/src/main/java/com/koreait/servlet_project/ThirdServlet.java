package com.koreait.servlet_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(
                """
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>THIRD</title>
                </head>
                <body>
                    <form action="/second">
                        <b>이름: </b><input type="text" name="name"> <br>
                        <b>나이: </b><input type="text" name="age"> <br>
                        <button>전송하기^-^</button>
                    </form>
                </body>
                </html>
                """);
    }
}
