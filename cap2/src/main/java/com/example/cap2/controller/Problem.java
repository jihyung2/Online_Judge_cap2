package com.example.cap2.controller;

public class Problem {
    private String name;
    private String description;
    private String code;

    public Problem() {
        // 기본 생성자
    }

    public Problem(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }
}