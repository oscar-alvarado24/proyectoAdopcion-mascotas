package com.project.adoption.pet.api.handler;

import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;

import java.util.List;

public interface IPetHandler {
    PetResponse getPet(Long petId);

    String createPet(PetRequest petRequest);

    String updatePet(Long petId, PetRequest petRequest);

    String deletePet(Long petId);

    List<PetResponse> getAvailabilityPet();

    List<PetResponse> getPetsByListId(List<Long> listId);
}
