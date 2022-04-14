package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.Test;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;
import com.introidx.lhc_backend.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 15-04-2022
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<Test> fetchAllTests() {
        return null;
    }

    @Override
    public Test fetchTestById(Integer testId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Test addTest(String subjectCode, String topicName, String time, String marks) throws EtBadRequestException {
        int testId = testRepository.createTest(subjectCode, topicName, time, marks);
        return testRepository.findTestById(testId);

    }
}
