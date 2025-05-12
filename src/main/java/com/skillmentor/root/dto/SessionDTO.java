package com.skillmentor.root.dto;

import java.time.Instant;

public class SessionDTO {
    private Integer sessionId;
    private StudentDTO studentDTO;
    private ClassRoomDTO classRoomDTO;
    private MentorDTO mentorDTO;
    private String topic;
    private Instant startTime;
    private Instant endTime;

    public SessionDTO(Integer sessionId, StudentDTO studentDTO, ClassRoomDTO classRoomDTO, MentorDTO mentorDTO, Instant startTime, Instant endTime, String topic) {
        this.sessionId = sessionId;
        this.studentDTO = studentDTO;
        this.classRoomDTO = classRoomDTO;
        this.mentorDTO = mentorDTO;
        this.startTime = startTime;
        this.endTime = endTime;
        this.topic = topic;
    }

    public SessionDTO(){

    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public ClassRoomDTO getClassRoomDTO() {
        return classRoomDTO;
    }

    public void setClassRoomDTO(ClassRoomDTO classRoomDTO) {
        this.classRoomDTO = classRoomDTO;
    }

    public MentorDTO getMentorDTO() {
        return mentorDTO;
    }

    public void setMentorDTO(MentorDTO mentorDTO) {
        this.mentorDTO = mentorDTO;
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
