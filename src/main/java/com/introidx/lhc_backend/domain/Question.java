package com.introidx.lhc_backend.domain;

/**
 * Created by PRAKASH RANJAN on 16-04-2022
 */
public class Question {
    private Integer questionId;
    private Integer testId;
    private String questionTitle;
    private String questionMarks;

    public Question(Integer questionId, Integer testId, String questionTitle, String questionMarks) {
        this.questionId = questionId;
        this.testId = testId;
        this.questionTitle = questionTitle;
        this.questionMarks = questionMarks;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionMarks() {
        return questionMarks;
    }

    public void setQuestionMarks(String questionMarks) {
        this.questionMarks = questionMarks;
    }
}
