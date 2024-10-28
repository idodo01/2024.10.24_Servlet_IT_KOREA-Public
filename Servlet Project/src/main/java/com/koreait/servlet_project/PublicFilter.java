package com.koreait.servlet_project;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// filter은 간단한 처리를 할 수 있도록 해준다

// Filter가 동작되는 매핑 경로. /* => 모든 경로에서 필터를 실행하겠음!
@WebFilter("/filter/*")
public class PublicFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException
    {
        System.out.println("Filter 실행되었음~ [PRE]");
        servletRequest.setCharacterEncoding("UTF-8");
        try {
            Integer.parseInt(servletRequest.getParameter("data"));
            // 실제 doGet, doPost 등 서블릿의 실행 메서드로 이동해라!
            // request, response 객체를 전달한다
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Filter 실행되었음~ [POST]");
        }catch (Exception e){
            System.out.println("데이터에서 오류가 발생했습니다!!");
            servletResponse.getOutputStream().println("<b>^-^</b>");

        }
    }
}
