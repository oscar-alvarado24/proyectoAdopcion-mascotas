package com.project.adoption.pet.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotNull(message = "La edad es obligatoria")
        @Min(value = 0, message = "La edad debe ser mayor o igual a 0")
        int age,

        @NotBlank(message = "El género es obligatorio")
        String gender,

        @NotNull(message = "El tipo de mascota es obligatorio")
        Long typePet
) {}
