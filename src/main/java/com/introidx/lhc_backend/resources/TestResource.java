package com.introidx.lhc_backend.resources;

import com.introidx.lhc_backend.domain.Test;
import com.introidx.lhc_backend.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
@RestController
@RequestMapping("/api/tests")
public class TestResource {

    @Autowired
    TestService testService;

    @PostMapping("")
    public ResponseEntity<Test> addTest(@RequestBody Map<String, Object> testMap) {
        String subjectCode = (String) testMap.get("subjectCode");
        String topicName = (String) testMap.get("topicName");
        String time = (String) testMap.get("time");
        String marks = (String) testMap.get("marks");

        Test test = testService.addTest(subjectCode, topicName, time, marks);
        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Test>> getAllTests() {
        List<Test> tests = testService.fetchAllTests();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }


}
