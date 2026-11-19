package com.example.studentmanagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record CreateStudentRequest(
        @NotNull @Positive Integer studentId,
        @NotBlank String studentName,
        @NotBlank @Email String email,
        String courseName,
        @DecimalMin("0.0") BigDecimal programmingScore,
        @DecimalMin("0.0") BigDecimal mathematicsScore,
        List<@NotBlank String> skills) {
}
