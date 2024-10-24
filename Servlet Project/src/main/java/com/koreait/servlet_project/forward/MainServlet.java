package com.koreait.servlet_project.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// webapp > WEB-INF > web에 따로 추가 없이
// 똑같이 작동할 수 있음
@WebServlet("/forward/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== MainServlet doGet ===");
        // 1. html를 resources가 아닌, webapp에 추가해야함
//        resp.sendRedirect("/forward.html");
//        System.out.println("xclvjxclbkj");

        // 2. 브라우저 이동
        // http://localhost:8080/forward/main로 접근하는데,
        // http://localhost:8080/forward/response로 이동함
//        resp.addHeader("Refresh", "3;url=/forward/response");

        // 3. 브라우저 이동 별도 없이,
        // 주소는 main인데, 내용은 response
        // RequestDispatcher dispatcher = req.getRequestDispatcher("/forward/response");
        //        dispatcher.forward(req, resp);

        // 4.1 데이터 받기
         String data = req.getParameter("data");
        System.out.println("data를 받았습니다: " + data);
        resp.getWriter().write(data); // 화면에 data를 보여줌

        // 4.2 response로 그대로 넘기기
        resp.sendRedirect("/forward/response?data=" + data);

    }
}
