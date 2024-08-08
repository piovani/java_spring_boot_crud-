package com.example.java_spring_boot_crud.core.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank
        String name,
        @NotNull
        BigDecimal value) {

}
