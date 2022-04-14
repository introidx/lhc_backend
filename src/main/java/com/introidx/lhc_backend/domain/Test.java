package com.introidx.lhc_backend.domain;

/**
 * Created by PRAKASH RANJAN on 15-04-2022
 */
public class Test {
    private Integer testId;
    private String subjectCode;
    private String topicName;
    private String time;
    private String marks;

    public Test(Integer testId, String subjectCode, String topicName, String time, String marks) {
        this.testId = testId;
        this.subjectCode = subjectCode;
        this.topicName = topicName;
        this.time = time;
        this.marks = marks;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
