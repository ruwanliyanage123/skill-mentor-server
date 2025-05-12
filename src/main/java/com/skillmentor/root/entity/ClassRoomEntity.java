package com.skillmentor.root.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classroom")
public class ClassRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_room_id")
    private Integer classRoomId;
    @Column(name = "title")
    private String title;
    @Column(name = "session_fee")
    private Double sessionFee;
    @Column(name = "enrolled_student_count")
    private Integer enrolledStudentCount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mentor_id", referencedColumnName = "mentor_id")
    private MentorEntity mentor;
    @OneToMany(mappedBy = "classRoomEntity", fetch = FetchType.EAGER)
    private List<SessionEntity> sessionEntityList = new ArrayList<>();

    public ClassRoomEntity() {
    }

    public ClassRoomEntity(Integer classRoomId, String name, Double sessionFee, Integer enrolledStudentCount, MentorEntity mentorEntity, List<SessionEntity> sessionEntityList) {
        this.classRoomId = classRoomId;
        this.title = name;
        this.sessionFee = sessionFee;
        this.enrolledStudentCount = enrolledStudentCount;
        this.mentor = mentorEntity;
        this.sessionEntityList = sessionEntityList;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSessionFee() {
        return sessionFee;
    }

    public void setSessionFee(Double sessionFee) {
        this.sessionFee = sessionFee;
    }

    public Integer getEnrolledStudentCount() {
        return enrolledStudentCount;
    }

    public void setEnrolledStudentCount(Integer enrolledStudentCount) {
        this.enrolledStudentCount = enrolledStudentCount;
    }

    public void setMentor(MentorEntity mentor) {
        this.mentor = mentor;
    }

    public MentorEntity getMentor() {
        return mentor;
    }

    public void setSessionEntityList(List<SessionEntity> sessionEntityList) {
        this.sessionEntityList = sessionEntityList;
    }

    public List<SessionEntity> getSessionEntityList() {
        return sessionEntityList;
    }
}
