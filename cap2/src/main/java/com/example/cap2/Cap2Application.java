package com.example.cap2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.cap2.repository")
@EntityScan(basePackages = "com.example.cap2.entity")// 엔티티 클래스의 패키지 경로 지정
public class Cap2Application {

    public static void main(String[] args) {
        SpringApplication.run(Cap2Application.class, args);
    }

}
