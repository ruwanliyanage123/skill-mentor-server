package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoomDTO {
    @NotNull
    @JsonProperty("class_room_id")
    private Integer classRoomId;
    @NotBlank
    @JsonProperty("title")
    private String title;
    @NotNull
    @JsonProperty("enrolled_student_count")
    private Integer enrolledStudentCount;
    @NotNull
    @JsonProperty("mentor")
    private MentorDTO mentorDTO;
}
