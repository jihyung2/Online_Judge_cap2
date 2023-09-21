package com.example.cap2.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class restapi {

    @PostMapping("/submit")
    public String sendDataToPython(@RequestBody Map<String, String> payload) {
        try {
            String code = payload.get("code");
            String name = payload.get("name");

            // 코드 내용 확인 및 처리
            System.out.println("Received code: " + code);
            System.out.println("Received name: " + name);

            // RestTemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate();

            // 파이썬 서버의 URL
            String pythonServerUrl = "http://127.0.0.1:8055/submit";

            // 파일 내용 읽기
            Path filePath = Paths.get("../UserAnswer/" + name + "_output.txt");
            byte[] fileContentBytes = Files.readAllBytes(filePath);
            String fileContentString = new String(fileContentBytes);

            // 파일 내용과 코드를 Map에 저장
            Map<String, String> map = new HashMap<>();
            map.put("output", fileContentString);
            map.put("code", code);

            // HttpEntity 객체 생성 (요청 본문과 헤더 포함)
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);

            ResponseEntity<Map> responseFromPythonServer =
                    restTemplate.postForEntity(pythonServerUrl, requestEntity, Map.class);

            if (responseFromPythonServer.getStatusCodeValue() == 200) {
                Map<String, Object> responseBody = responseFromPythonServer.getBody();
                return responseBody.get("result").toString();
            } else {
                return "파이썬 서버로 데이터 전송 중 오류 발생";
            }


        } catch (Exception e) {
            e.printStackTrace();
            return "데이터 전송 중 오류 발생: " + e.getMessage();
        }

    }
}
