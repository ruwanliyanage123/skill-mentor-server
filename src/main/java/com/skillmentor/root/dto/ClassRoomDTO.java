package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomDTO {
    @JsonProperty("id")
    private Integer classRoomId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("fee")
    private Double sessionFee;
    @JsonProperty("studentCount")
    private Integer enrolledStudentCount;
    @JsonProperty("mentors")
    private List<MentorDTO> mentorDTOList = new ArrayList<>();
    public ClassRoomDTO() {
    }

    public ClassRoomDTO(Integer classRoomId, String name, Double sessionFee, Integer enrolledStudentCount, List<MentorDTO> mentorDTOList) {
        this.classRoomId = classRoomId;
        this.title = name;
        this.sessionFee = sessionFee;
        this.enrolledStudentCount = enrolledStudentCount;
        this.mentorDTOList = mentorDTOList;
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

    public void setMentorDTOList(List<MentorDTO> mentorDTOList) {
        this.mentorDTOList = mentorDTOList;
    }

    public List<MentorDTO> getMentorDTOList() {
        return mentorDTOList;
    }
}