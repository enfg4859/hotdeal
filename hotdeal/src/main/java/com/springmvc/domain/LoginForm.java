package com.springmvc.domain;

public class LoginForm {
    private String user_id;
    private String password;

    // 생성자, 게터, 세터 등 필요한 메서드를 추가할 수 있음

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}