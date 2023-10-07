package com.example.cap2.controller;

public class UserChatting {
    private String name;
    private String text;

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getText(){return text;}
    public void setText(String text) {
        this.text = text;
    }
    public UserChatting(String name, String text) {
        super();
        this.name = name;
        this.text = text;
    }

    // 생성자, getter 및 setter 메서드 추가
}
