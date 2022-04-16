package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.Question;
import com.introidx.lhc_backend.exceptions.EtBadRequestException;
import com.introidx.lhc_backend.exceptions.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepository{

    private static final String SQL_CREATE_QUESTION = "INSERT INTO LHC_QUESTIONS (QUESTION_ID, TEST_ID , QUESTION_TITLE, QUESTION_MARKS) " +
            "VALUES(NEXTVAL('LHC_QUESTIONS_SEQ'), ? , ? , ?)";

    private static final String SQL_FIND_QUESTION_BY_ID = "SELECT QUESTION_ID, TEST_ID , QUESTION_TITLE, QUESTION_MARKS FROM LHC_QUESTIONS WHERE QUESTION_ID = ?";
    private static final String SQL_FIND_QUESTIONS_OF_ONE_TEST = "SELECT * FROM LHC_QUESTIONS WHERE TEST_ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Question> findQuestionsOfOneTest(Integer testId) throws EtResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_QUESTIONS_OF_ONE_TEST ,new Object[]{testId} , questionMapper);
    }

    @Override
    public Question findQuestionById(Integer questionId) throws EtResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_QUESTION_BY_ID, new Object[]{questionId} , questionMapper);
        }catch (Exception e){
            throw new EtResourceNotFoundException("Question Not Found");
        }
    }

    @Override
    public Integer createQuestion(Integer testId, String questionTitle, String questionMarks) throws EtBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE_QUESTION, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, testId);
                ps.setString(2, questionTitle);
                ps.setString(3, questionMarks);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("QUESTION_ID");
        }catch (Exception e){
            throw new EtBadRequestException("Invalid Request");
        }
    }

    private RowMapper<Question> questionMapper = ((rs, rowNum) -> {
      return new Question(rs.getInt("QUESTION_ID"),
              rs.getInt("TEST_ID"),
              rs.getString("QUESTION_TITLE"),
              rs.getString("QUESTION_MARKS")
              );
    });
}
