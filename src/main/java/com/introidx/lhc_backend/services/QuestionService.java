package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.Question;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
public interface QuestionService {
    List<Question> fetchAllQuestionsOfOneTest(Integer testId);
    Question fetchQuestionById(Integer questionId) throws EtResourceNotFoundException;
    Question addQuestion(Integer testId , String questionTitle, String questionMarks) throws EtBadRequestException;
}
