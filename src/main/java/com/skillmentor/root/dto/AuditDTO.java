package com.skillmentor.root.dto;

import java.time.Instant;

public class AuditDTO {
    private Integer sessionId;
    private Integer studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentPhoneNumber;
    private String classTitle;
    private Integer mentorId;
    private String mentorFirstName;
    private String mentorLastName;
    private String mentorPhoneNumber;
    private Double fee;
    private Instant startTime;
    private Instant endTime;
    private String topic;

    public AuditDTO() {}

    public AuditDTO(Integer sessionId, Integer studentId, String studentFirstName, String studentLastName, String studentEmail, String studentPhoneNumber, String classTitle, Integer mentorId, String mentorFirstName, String mentorLastName, String mentorPhoneNumber, Double fee, Instant startTime, Instant endTime, String topic) {
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.classTitle = classTitle;
        this.mentorId = mentorId;
        this.mentorFirstName = mentorFirstName;
        this.mentorLastName = mentorLastName;
        this.mentorPhoneNumber = mentorPhoneNumber;
        this.fee = fee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.topic = topic;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorFirstName() {
        return mentorFirstName;
    }

    public void setMentorFirstName(String mentorFirstName) {
        this.mentorFirstName = mentorFirstName;
    }

    public String getMentorLastName() {
        return mentorLastName;
    }

    public void setMentorLastName(String mentorLastName) {
        this.mentorLastName = mentorLastName;
    }

    public String getMentorPhoneNumber() {
        return mentorPhoneNumber;
    }

    public void setMentorPhoneNumber(String mentorPhoneNumber) {
        this.mentorPhoneNumber = mentorPhoneNumber;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}