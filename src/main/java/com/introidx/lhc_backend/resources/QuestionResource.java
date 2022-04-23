package com.introidx.lhc_backend.resources;

import com.introidx.lhc_backend.domain.Question;
import com.introidx.lhc_backend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/questions")
public class QuestionResource {

    @Autowired
    QuestionService questionService;

    @PostMapping("")
    public ResponseEntity<Question> addQuestion(@RequestBody Map<String, Object> questionMap) {
        Integer testId = (Integer) questionMap.get("testId");
        String questionTitle = (String) questionMap.get("questionTitle");
        String questionMarks = (String) questionMap.get("questionMarks");
        Question question = questionService.addQuestion(testId, questionTitle, questionMarks);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<List<Question>> getAllQuestionsOfOneTest(@PathVariable("testId") Integer testId) {
        List<Question> questions = questionService.fetchAllQuestionsOfOneTest(testId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }


}
