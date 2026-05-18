package com.result.service;

import com.result.entities.Result;
import com.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result getResultById(Long resultId) {
        return resultRepository.findById(resultId).orElse(null);
    }

    public void deleteResult(Long resultId) {
        resultRepository.deleteById(resultId);
    }
}
