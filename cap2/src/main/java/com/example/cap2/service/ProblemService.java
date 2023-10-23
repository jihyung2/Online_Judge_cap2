package com.example.cap2.service;

import com.example.cap2.entity.Problem;
import com.example.cap2.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Problem saveProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    public List<Problem> getDeleteProblems(String problemName) { //Request에서 받은 삭제할 문제 이름을
        // 문제 이름에 해당하는 문제를 찾습니다.
        List<Problem> deleteProblems = problemRepository.findByName(problemName); // Repository에서 name을 찾기
        //List<Problem> deleteProblems = problemRepository.findAll(); 이렇게하면 모든 문제를 다 지우는 내용임
        // 찾은 문제를 삭제합니다.
        problemRepository.deleteAll(deleteProblems); // 찾은 이름과 연결된 정보를 다 지운다.

        return deleteProblems;
    }
// 데이터베이스에서 읽어오기 -> 이방법은 근데 줄넘김이 안되서 패스
//    public List<String> getDsProblems(String problemName) { //Request에서 받은 삭제할 문제 이름을
//        // 문제 이름에 해당하는 문제를 찾습니다.
//        List<Problem> DsProblems = problemRepository.findByName(problemName); // Repository에서 name을 찾기
//        List<String> descriptions = new ArrayList<>();
//
//        // Iterate over problems and add their descriptions to list
//        for (Problem problem : DsProblems) {
//            descriptions.add(problem.getDescription());
//        }
//        System.out.println(descriptions);
//        return descriptions;
//    }
}
