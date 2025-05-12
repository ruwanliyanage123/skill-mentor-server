package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassRoomDTO {
    private Integer classRoomId;
    private String title;
    private Integer enrolledStudentCount;
    @JsonProperty("mentor")
    private MentorDTO mentorDTO;

    public ClassRoomDTO() {
    }

    public ClassRoomDTO(Integer classRoomId, String name, Integer enrolledStudentCount, MentorDTO mentorDTO) {
        this.classRoomId = classRoomId;
        this.title = name;
        this.enrolledStudentCount = enrolledStudentCount;
        this.mentorDTO = mentorDTO;
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

    public Integer getEnrolledStudentCount() {
        return enrolledStudentCount;
    }

    public void setEnrolledStudentCount(Integer enrolledStudentCount) {
        this.enrolledStudentCount = enrolledStudentCount;
    }

    public MentorDTO getMentorDTO() {
        return mentorDTO;
    }

    public void setMentorDTO(MentorDTO mentorDTO) {
        this.mentorDTO = mentorDTO;
    }
}