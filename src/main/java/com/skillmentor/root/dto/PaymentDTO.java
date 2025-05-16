package com.skillmentor.root.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    @NotNull
    @JsonProperty("mentor_id")
    private Integer mentorId;
    @NotBlank
    @JsonProperty("mentor_name")
    private String mentorName;
    @NotNull
    @Min(0)
    @JsonProperty("total_fee")
    private Double totalFee;
}
