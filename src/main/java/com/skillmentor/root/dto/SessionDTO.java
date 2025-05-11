package com.skillmentor.root.dto;

import java.time.Instant;

public class SessionDTO {

    private Integer sessionId;
    private ClassRoomDTO classRoom;
    private MentorDTO mentor;
    private StudentDTO student;
    private Instant startTime;
    private Instant endTime;

    public SessionDTO(Integer sessionId, ClassRoomDTO classRoom, MentorDTO mentor, StudentDTO student, Instant startTime, Instant endTime) {
        this.sessionId = sessionId;
        this.classRoom = classRoom;
        this.mentor = mentor;
        this.student = student;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public SessionDTO() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public ClassRoomDTO getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoomDTO classRoom) {
        this.classRoom = classRoom;
    }

    public MentorDTO getMentor() {
        return mentor;
    }

    public void setMentor(MentorDTO mentor) {
        this.mentor = mentor;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
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
