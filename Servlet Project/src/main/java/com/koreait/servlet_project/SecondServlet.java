package com.koreait.servlet_project;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

// 웹 요청을 받을 수 있는 클래스!
public class SecondServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("SecondServlet init");
    }

    // GET 요청을 받았을 때 자동 실행된다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8"); // 화면에 한글이 나올 수 있도록 문자셋을 정한다
        resp.setContentType("text/html"); // 화면에 쓰는건 text/plain이 아니라 html형식이라고 알려준다

        // 응답 데이터를 쓸 수 있는 Writer 객체를 가져옴
        // System.out.prinln은 콘솔창에 write하지만,
        // response 객체의 PrintWriter는 웹 브라우저 창에 write한다
        PrintWriter writer = resp.getWriter();

        // http://localhost:8080/second?name=KIM&age=10
//        System.out.println("SecondServlet doGet 요청을 받았습니다");
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//        writer.println("받은 name: " + name);
//        writer.println("받은 age: " + age);

        /////////////////////////////////////////////////////////////
        System.out.println("SecondServlet doGet 요청을 받았습니다");
        // 요청에 사용된 파라미터 개수가 적거나, 파라미터 이름이 확실할 때!
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//        String[] lang = req.getParameterValues("lang");
//        writer.println("받은 name: " + name);
//        writer.println("받은 age: " + age);
//        writer.println("받은 lang: " + Arrays.toString(lang) );

        // 파라미터 개수가 너무 많아서 일일이 적기 힘들다 ㅠㅠ
        // 요청에 사용된 name과 value의 쌍들을 전부 가져온다
        Map<String, String[]> paramMap = req.getParameterMap();
        var entrySet = paramMap.entrySet(); //name과 value의 쌍 들
        // 해당 엔트리(쌍)들을 순회한다
        for (var entry : entrySet) {
            var key = entry.getKey(); // 요청에 사용된 name값
            var value = entry.getValue(); // 요청에 사용된 value값
            writer.println(key + ": " + Arrays.toString(value));
        }
    }
}
