package com.introidx.lhc_backend.services;

import com.introidx.lhc_backend.domain.Question;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;
import com.introidx.lhc_backend.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> fetchAllQuestionsOfOneTest(Integer testId) {
        return questionRepository.findQuestionsOfOneTest(testId);
    }

    @Override
    public Question fetchQuestionById(Integer questionId) throws EtResourceNotFoundException {
        return questionRepository.findQuestionById(questionId);
    }

    @Override
    public Question addQuestion(Integer testId, String questionTitle, String questionMarks) throws EtBadRequestException {
        int questionId = questionRepository.createQuestion(testId, questionTitle, questionMarks);
        return questionRepository.findQuestionById(questionId);
    }
}
