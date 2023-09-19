package com.example.cap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.File;

@RestController
@RequestMapping("/api/problems")
public class Request {

    @PostMapping("/add")
    public ResponseEntity<String> addProblem(@RequestBody ProblemRequest request) {
        try {
            Problem problem = new Problem(request.getName(), request.getDescription(), request.getCode());

            String pythonFilePath = "../UserAnswer/"+request.getName()+".py";

            String pythonCode = request.getCode();

            File pythonFile = new File(pythonFilePath);

            pythonFile.getParentFile().mkdirs();

            FileWriter fileWriter = new FileWriter(pythonFile);
            fileWriter.write(pythonCode);
            fileWriter.close();

            System.out.println("파이썬 파일이 UserAnswer폴더에 생성되었습니다.");

            return new ResponseEntity<>("문제가 정상적으로 추가되었습니다.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("문제 추가 에러 발생: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}