package com.example.cap2.service;

import com.example.cap2.entity.Problem;
import com.example.cap2.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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

    public List<Problem> getDeleteProblems(String problemName) {
        // 문제 이름에 해당하는 문제를 찾습니다.
        List<Problem> deleteProblems = problemRepository.findByName(problemName);

        // 찾은 문제를 삭제합니다.
        problemRepository.deleteAll(deleteProblems);

        return deleteProblems;
    }
}
