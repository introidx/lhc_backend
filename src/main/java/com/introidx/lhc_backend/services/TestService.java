package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.Test;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 15-04-2022
 */
public interface TestService {
    List<Test> fetchAllTests();
    Test fetchTestById(Integer testId) throws EtResourceNotFoundException;
    Test addTest(String subjectCode, String topicName, String time, String marks) throws EtBadRequestException;

}
