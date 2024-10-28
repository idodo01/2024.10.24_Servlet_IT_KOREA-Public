package com.koreait.servlet_project.login;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();


        HttpSession session = req.getSession(false);
        if(session == null) {
            // sendRedirect, forward 등 이동 코드는 실행해도 아래 코드들이 실행안되는것이 아님
            // 응답 객체에 login페이지로 이동하라고 추가함 (브라우저한테 전달한다는 뜻)
            resp.sendRedirect("/login");
            return; // 아래 코드들을 실행안하도록 만들어야 함
        }
        // 로그인 하지 않았다면
//        if(session.getAttribute("id") == null) {
//            resp.sendRedirect("/login"); // 로그인페이지로 보내버림
//        }
        User user = (User) session.getAttribute("user");
        out.println("<h1>당신의 정보</h1>");
        out.println("<b>아이디:</b>" + user.getId() + "<br>");
        out.println("<b>비번:</b>" + user.getPw() + "<br>");
        out.println("<b>닉네임:</b>" + user.getNick() + "<br>");
        out.println("<b>나이:</b>" + user.getAge() + "<br>");


    }
}
