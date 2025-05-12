package com.skillmentor.root.dto;

public class PaymentDTO {
    private Integer mentorId;
    private String mentorName;
    private Double totalFee;

    public PaymentDTO(Integer mentorId, String mentorName, Double totalFee) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.totalFee = totalFee;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
