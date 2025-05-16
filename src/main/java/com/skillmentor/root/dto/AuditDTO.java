package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditDTO {
    @NotNull
    @JsonProperty("session_id")
    private Integer sessionId;
    @NotNull
    @JsonProperty("student_id")
    private Integer studentId;
    @NotBlank
    @JsonProperty("student_first_name")
    private String studentFirstName;
    @NotBlank
    @JsonProperty("student_last_name")
    private String studentLastName;
    @NotBlank
    @JsonProperty("student_email")
    private String studentEmail;
    @NotBlank
    @JsonProperty("student_phone_number")
    private String studentPhoneNumber;
    @NotBlank
    @JsonProperty("class_title")
    private String classTitle;
    @NotNull
    @JsonProperty("mentor_id")
    private Integer mentorId;
    @NotBlank
    @JsonProperty("mentor_first_name")
    private String mentorFirstName;
    @NotBlank
    @JsonProperty("mentor_last_name")
    private String mentorLastName;
    @NotBlank
    @JsonProperty("mentor_phone_number")
    private String mentorPhoneNumber;
    @NotNull
    @JsonProperty("fee")
    private Double fee;
    @NotNull
    @JsonProperty("start_time")
    private Instant startTime;
    @NotNull
    @JsonProperty("end_time")
    private Instant endTime;
    @NotBlank
    @JsonProperty("topic")
    private String topic;
}
