package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.Test;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 15-04-2022
 */
public interface TestRepository {

    List<Test> findAllTests() throws EtResourceNotFoundException;
    Test findTestById(Integer testId) throws EtResourceNotFoundException;
    Integer createTest(String subjectCode, String topicName, String time, String marks) throws EtBadRequestException;
}

/*private String subjectCode;
    private String topicName;
    private String time;
    private String marks;

 */
