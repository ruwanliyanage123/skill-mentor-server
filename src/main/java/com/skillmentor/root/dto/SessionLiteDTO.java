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
public class SessionLiteDTO {
    @NotNull
    @JsonProperty("session_id")
    private Integer sessionId;
    @NotNull
    @JsonProperty("student_id")
    private Integer studentId;
    @NotNull
    @JsonProperty("class_room_id")
    private Integer classRoomId;
    @NotNull
    @JsonProperty("mentor_id")
    private Integer mentorId;
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
