package com.example.cap2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Controller
public class restapi {

    @PostMapping("/sendData")
    @ResponseBody
    public String sendDataToPython(@RequestParam String inputData) {
        try {
            // 파이썬 서버에 연결
            Socket socket = new Socket("http://127.0.0.1", 8090);

            // 데이터 전송
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(inputData.getBytes());

            // 연결 종료
            socket.close();

            return "데이터가 성공적으로 전송되었습니다.";
        } catch (IOException e) {
            e.printStackTrace();
            return "데이터 전송 중 오류 발생: " + e.getMessage();
        }
    }
}