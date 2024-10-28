package com.koreait.servlet_project.login;

public class User {
    private String id;
    private String pw;
    private int age;
    private String nick;

    public User(String id, String pw, int age, String nick) {
        this.id = id;
        this.pw = pw;
        this.age = age;
        this.nick = nick;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public int getAge() {
        return age;
    }

    public String getNick() {
        return nick;
    }
}
