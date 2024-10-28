package com.koreait.servlet_project.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session_req")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // Session은 Cookie와 달리, 문자열이 아닌 객체를 저장할 수 있다
        // 브라우저가 아닌 서버 컴퓨터에 저장된다(메모리)
        // 쿠키와 동일하게, 브라우저마다 세션은 달라진다.
        // 도메인에 따라 세션은 달라진다 (같아지면 큰일납니다!)
        session.setAttribute("data", req.getParameter("data"));

    }
}