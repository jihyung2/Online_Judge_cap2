package com.example.cap2.controller;

public class UserRequest {
    private String name;
    private String code;

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getCode(){return code;}
    public void setCode(String code) {
        this.code = code;
    }
    public UserRequest(String name, String code) {
        super();
        this.name = name;
        this.code = code;
    }

    // 생성자, getter 및 setter 메서드 추가
}
