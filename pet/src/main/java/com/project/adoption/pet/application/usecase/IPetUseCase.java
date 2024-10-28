package com.project.adoption.pet.application.usecase;

import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;
import com.project.adoption.pet.application.exception.PetTypeNotExistException;
import com.project.adoption.pet.util.Constants;

import java.util.List;

public interface IPetUseCase {
    PetResponse getPet(Long petId);

    String createPet(PetRequest petRequest);

    String updatePet(Long petId, PetRequest petRequest);

    String deletePet(Long petId);

    List<PetResponse> getAvailabilityPet();

    List<PetResponse> getPetsByListId(List<Long> listId);
}