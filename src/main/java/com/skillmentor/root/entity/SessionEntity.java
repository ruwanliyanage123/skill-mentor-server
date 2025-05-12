package com.skillmentor.root.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "session")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer sessionId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentEntity studentEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_room_id", referencedColumnName = "class_room_id")
    private ClassRoomEntity classRoomEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id")
    private MentorEntity mentorEntity;
    @Column(name ="start_time")
    private Instant startTime;
    @Column(name = "end_time")
    private Instant endTime;

    public SessionEntity(Integer sessionId, StudentEntity studentEntity, ClassRoomEntity classRoomEntity, MentorEntity mentorEntity, Instant startTime, Instant endTime) {
        this.sessionId = sessionId;
        this.studentEntity = studentEntity;
        this.classRoomEntity = classRoomEntity;
        this.mentorEntity = mentorEntity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public SessionEntity(){

    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public ClassRoomEntity getClassRoomEntity() {
        return classRoomEntity;
    }

    public void setClassRoomEntity(ClassRoomEntity classRoomEntity) {
        this.classRoomEntity = classRoomEntity;
    }

    public MentorEntity getMentorEntity() {
        return mentorEntity;
    }

    public void setMentorEntity(MentorEntity mentorEntity) {
        this.mentorEntity = mentorEntity;
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
