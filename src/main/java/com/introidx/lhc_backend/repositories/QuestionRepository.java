package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.Question;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
public interface QuestionRepository {
    List<Question> findQuestionsOfOneTest(Integer testId) throws EtResourceNotFoundException;
    Question findQuestionById(Integer questionId) throws EtResourceNotFoundException;
    Integer createQuestion(Integer testId , String questionTitle, String questionMarks) throws EtBadRequestException;

}
