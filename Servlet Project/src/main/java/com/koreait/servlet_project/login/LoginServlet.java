package com.koreait.servlet_project.login;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

// webapp > login.html 참고
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // session이 미리 만들어져 있다? 로그인 한번 했다는 뜻!
        if(!session.isNew()) {
            resp.sendRedirect("/main");
        }else{
            session.invalidate();
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        // id는 korea고 pw는 123으로 정해놓자
        if(id.equals("korea") && pw.equals("123")){
            out.println("로그인 완료^-^");
            // 로그인했을 때 세션은 최초 생성이 된다
            User user = new User(id, pw, 50, "코리아!");
            session.setAttribute("user", user);
        }else{
            out.println("로그인 실패 ㅠㅠ");
            session.invalidate(); // 만들어진 세션을 제거한다
        }

    }
}
