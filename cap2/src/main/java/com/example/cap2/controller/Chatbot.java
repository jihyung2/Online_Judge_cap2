package com.example.cap2.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

@RestController
public class Chatbot {

    @PostMapping("/chatting")
    public String sendDataToPython(@RequestBody UserChatting chatting) {
        try {
            String text = chatting.getText();
            String name = chatting.getName();

            System.out.println("Received name: " + name);
            System.out.println("Received text: " + text);

            // RestTemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate();

            // 파이썬 서버의 URL
            String pythonServerUrl = "http://127.0.0.1:5010/query/NORMAL";

            // 파일 내용과 코드를 Map에 저장
            Map<String, String> map = new HashMap<>();
            map.put("query", text);

            // HttpEntity 객체 생성 (요청 본문과 헤더 포함)
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);

            ResponseEntity<Map> responseFromPythonServer =
                    restTemplate.postForEntity(pythonServerUrl, requestEntity, Map.class);

            if (responseFromPythonServer.getStatusCodeValue() == 200) {
                Map<String, Object> responseBody = responseFromPythonServer.getBody();
                System.out.println("R3: " + responseBody.get("Answer").toString());
                return responseBody.get("Answer").toString();
            } else {
                return "챗봇 서버 에러 발생!";
            }


        } catch (Exception e) {
            e.printStackTrace();
            return "데이터 전송 중 오류 발생: " + e.getMessage();
        }

    }
}
