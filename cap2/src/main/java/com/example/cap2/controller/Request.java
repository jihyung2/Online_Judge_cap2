package com.example.cap2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import org.apache.commons.io.FileUtils;

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


            // RestTemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate();

            // 파이썬 서버의 URL
            String pythonServerUrl = "http://127.0.0.1:8055/addProblemRunCode";

            // 파이썬 코드를 Map에 저장
            Map<String, String> map = new HashMap<>();
            map.put("code", pythonCode);

            // Jackson ObjectMapper 객체 생성 및 Map을 JSON 문자열로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPythonCode = objectMapper.writeValueAsString(map);

            // HttpEntity 객체 생성 (요청 본문과 헤더 포함)
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> requestEntity = new HttpEntity<>(jsonPythonCode, headers);

            // POST 요청 보내기 및 응답 받기
            ResponseEntity<String> responseFromPythonServer
                    = restTemplate.postForEntity(pythonServerUrl, requestEntity, String.class);

            if (responseFromPythonServer.getStatusCodeValue() == 200) {
                BufferedWriter writer
                        = new BufferedWriter(new FileWriter("../UserAnswer/"+request.getName()+"_output.txt"));
                writer.write(responseFromPythonServer.getBody());
                writer.close();

                System.out.println("파이썬 실행 결과가 output.txt 파일에 저장되었습니다.");
            } else {
                System.out.println("Error occurred while sending code to Python server");
            }

            return ResponseEntity.ok("문제가 정상적으로 추가되었으며, 파이썬 실행 결과가 output.txt 파일에 저장되었습니다.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "문제 추가 에러 발생: " + e.getMessage());
        }
    }

    @GetMapping("/getOutput")
    public ResponseEntity<String> getOutput(@RequestParam String name) {
        try {
            File outputFile = new File("../UserAnswer/"+ name +"_output.txt");
            if (outputFile.exists()) {
                String output = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8);
                return ResponseEntity.ok(output);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading output file: " + e.getMessage());
        }
    }
}
