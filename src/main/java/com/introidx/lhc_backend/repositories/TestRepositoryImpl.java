package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.Test;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 15-04-2022
 */
public class TestRepositoryImpl implements TestRepository{
    @Override
    public List<Test> findAllTests() throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Test findTestById(Integer testId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Integer createTest(String subjectCode, String topicName, String time, String marks) throws EtBadRequestException {
        return null;
    }
}
