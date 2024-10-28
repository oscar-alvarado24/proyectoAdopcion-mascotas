package com.project.adoption.pet.application.dto;

import lombok.Builder;

@Builder
public record PetResponse (
        Long id,
        String name,
        int age,
        String gender,
        TypeResponse typePet
){}
