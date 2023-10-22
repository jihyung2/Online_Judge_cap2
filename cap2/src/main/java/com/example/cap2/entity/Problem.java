package com.example.cap2.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "Probleminfo")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private String code;

    public Long getId(){return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){return description;}
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode(){return code;}
    public void setCode(String code) {
        this.code = code;
    }
    public Problem(Long id, String name, String description, String code) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
    }

    // 생성자, getter 및 setter 메서드 추가
}
