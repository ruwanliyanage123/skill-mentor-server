package com.skillmentor.root.dto;

public class MentorDTO {
    private Integer mentorId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String title;
    private String profession;
    private String subject;
    private String phoneNumber;
    private String qualification;
    private Integer classRoomId;

    public MentorDTO() {}

    public MentorDTO(Integer mentorId, String firstName, String lastName, String address, String email,
                     String title, String profession, String subject, String qualification, Integer classRoomId, String phoneNumber) {
        this.mentorId = mentorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.title = title;
        this.profession = profession;
        this.subject = subject;
        this.qualification = qualification;
        this.classRoomId = classRoomId;
        this.phoneNumber = phoneNumber;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}