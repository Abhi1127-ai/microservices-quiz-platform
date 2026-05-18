package com.result.controller;

import com.result.entities.Result;
import com.result.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;


    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }

    @GetMapping
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/{resultId}")
    public Result getResultById(@PathVariable Long resultId) {
        return resultService.getResultById(resultId);
    }

    @DeleteMapping("/{resultId}")
    public String deleteResult(@PathVariable Long resultId) {
        resultService.deleteResult(resultId);
        return "Result deleted successfully";
    }
}
