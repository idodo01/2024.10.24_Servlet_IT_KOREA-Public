package com.koreait.servlet_project.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
//
//@WebListener("/listener/*")
//public class MyLoginListener implements HttpSessionAttributeListener {
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent event) {
//        System.out.println("attributeAdded");
//    }
//
//    @Override
//    public void attributeRemoved(HttpSessionBindingEvent event) {
//        System.out.println("attributeRemoved");
//    }
//}

@WebListener("/listener/*")
public class MyLoginListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("attributeRemoved");
    }
}
