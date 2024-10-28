package com.project.adoption.pet.domain.interfaces;

import com.project.adoption.pet.domain.entities.Pet;

import java.util.List;

public interface IPetRepository {
    String savePet(Pet pet);

    String updatePet(Long id, Pet pet);

    Pet getPet(Long petId);

    String deletePet(Long id);

    List<Pet> getAvailabilityPet();

    List<Pet> getPetsByListId(List<Long> listId);
}