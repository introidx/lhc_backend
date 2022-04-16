package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.Test;
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
 * Created by PRAKASH RANJAN on 15-04-2022
 */
@Repository
public class TestRepositoryImpl implements TestRepository {

    private static final String SQL_CREATE_TEST = "INSERT INTO LHC_TESTS (TEST_ID, SUBJECT_CODE, TOPIC_NAME, TIME, MARKS) " +
            "VALUES(NEXTVAL('LHC_TESTS_SEQ'), ?, ? ,? , ?)";
    private static final String SQL_FIND_TEST_BY_ID = "SELECT TEST_ID, SUBJECT_CODE, TOPIC_NAME, TIME, MARKS FROM LHC_TESTS WHERE TEST_ID = ?";
    private static final String SQL_FIND_ALL_TESTS = "SELECT * FROM LHC_TESTS";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Test> findAllTests() throws EtResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_ALL_TESTS, testRowMapper);
    }

    @Override
    public Test findTestById(Integer testId) throws EtResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_TEST_BY_ID, new Object[]{testId},testRowMapper);
        } catch (Exception e) {
            throw new EtResourceNotFoundException("Test Not Found");
        }
    }

    @Override
    public Integer createTest(String subjectCode, String topicName, String time, String marks) throws EtBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE_TEST, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, subjectCode);
                ps.setString(2, topicName);
                ps.setString(3, time);
                ps.setString(4, marks);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("TEST_ID");
        } catch (Exception e) {
            throw new EtBadRequestException("Invalid Request");

        }
    }

    private RowMapper<Test> testRowMapper = ((rs, rowNum) -> {
        return new Test(rs.getInt("TEST_ID"),
                rs.getString("SUBJECT_CODE"),
                rs.getString("TOPIC_NAME"),
                rs.getString("TIME"),
                rs.getString("MARKS")
        );
    });
}
