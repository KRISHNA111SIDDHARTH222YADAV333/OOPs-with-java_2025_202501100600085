package com.example.studentmanagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public record UpdateScoresAndSkillsRequest(
        @NotNull @DecimalMin("0.0") BigDecimal programmingScore,
        @NotNull @DecimalMin("0.0") BigDecimal mathematicsScore,
        @NotNull List<@NotBlank String> skills) {
}
