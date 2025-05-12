package com.skillmentor.root.dto;

import java.time.Instant;

public class SessionLiteDTO {
    private Integer sessionId;
    private Integer studentId;
    private Integer classRoomId;
    private Integer mentorId;
    private Instant startTime;
    private Instant endTime;

    public SessionLiteDTO(Integer sessionId, Integer studentId, Integer classRoomId, Integer mentorId, Instant startTime, Instant endTime) {
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.classRoomId = classRoomId;
        this.mentorId = mentorId;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
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
}
