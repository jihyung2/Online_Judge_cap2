package com.example.cap2.controller;

import com.example.cap2.entity.Problem;
import com.example.cap2.service.ProblemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import org.apache.commons.io.FileUtils;

@RestController
@RequestMapping("/api/problems")
public class Request {

    private final ProblemService problemService;

    public Request(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProblem(@RequestBody Problem request) {
        try {
            problemService.saveProblem(request);

            String pythonFilePath = "../UserAnswer/"+request.getName()+".py";

            String pythonCode = request.getCode();

            File pythonFile = new File(pythonFilePath);
            pythonFile.getParentFile().mkdirs();

            FileWriter fileWriter = new FileWriter(pythonFile);
            fileWriter.write(pythonCode);
            fileWriter.close();

            String pythonInfoPath = "../UserAnswer/"+request.getName()+"_info.txt";

            String pythonInfo = request.getDescription();

            File pythonFile2 = new File(pythonInfoPath);
            pythonFile2.getParentFile().mkdirs();

            FileWriter fileWriter2 = new FileWriter(pythonFile2);
            fileWriter2.write(pythonInfo);
            fileWriter2.close();

            System.out.println("파이썬 파일이 UserAnswer폴더에 생성되었습니다.");

            // RestTemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate();

            // 파이썬 서버의 URL
            String pythonServerUrl = "http://127.0.0.1:8035/addProblemRunCode";

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
                String jsonString = responseFromPythonServer.getBody();
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> map2 = mapper.readValue(jsonString, Map.class);
                String output = map2.get("output");

                BufferedWriter writer
                        = new BufferedWriter(new FileWriter("../UserAnswer/"+request.getName()+"_output.txt"));
                writer.write(output);
                writer.close();
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
    @GetMapping("/all")
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }

    @DeleteMapping("/delete") // 웹에서 a.jax로 보낸 문제의 이름 data: { name: delName }의 name을 가져와서 service로 전송
    public ResponseEntity<String> deleteProblem(@RequestParam("name") String problemName) {
        // 문제 삭제 로직
        // ResponseEntity는 반응을 가져오는거고, List는 안의 값을 가져오는거라고 생각하면 편할듯
        problemService.getDeleteProblems(problemName);
        return ResponseEntity.ok("Problem deleted successfully.");
    }
    @GetMapping("/getDescription")
    public ResponseEntity<String> getDescriptions(@RequestParam("name") String name) {
        try {
            File outputFile = new File("../UserAnswer/"+name+"_info.txt");
            if (outputFile.exists()) {
                String output = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8);
                System.out.println(output);
                return ResponseEntity.ok(output);
            } else {
                System.out.println("NO");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println("NO3");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading output file: " + e.getMessage());
        }
    }

}
