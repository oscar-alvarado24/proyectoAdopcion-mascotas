package com.project.adoption.pet.api.handler;

import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;
import com.project.adoption.pet.application.usecase.IPetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetHandler implements IPetHandler{
    private final IPetUseCase petUseCase;

    /**
     * get a pet by id
     * @param petId of pet to get
     * @return pet with petId
     */
    @Override
    public PetResponse getPet(Long petId) {
        return petUseCase.getPet(petId);
    }

    /**
     * create a pet
     * @param petRequest with pet data for create a pet
     * @return message of successfully creation
     */
    @Override
    public String createPet(PetRequest petRequest) {
        return petUseCase.createPet(petRequest);
    }

    /**
     * update a pet
     * @param petId of pet to update
     * @param petRequest with pet data updated
     * @return message of successfully update
     */
    @Override
    public String updatePet(Long petId, PetRequest petRequest) {
        return petUseCase.updatePet(petId, petRequest);
    }

    /**
     * delete a pet
     * @param petId of pet to delete
     * @return message of successfully delete
     */
    @Override
    public String deletePet(Long petId){
        return petUseCase.deletePet(petId);
    }

    /**
     * get list of pets that are availability for adopt
     * @return pet list
     */
    @Override
    public List<PetResponse> getAvailabilityPet() {
        return petUseCase.getAvailabilityPet();
    }

    /**
     * get list of pets corresponding to a list of id
     * @param listId for get list pet
     * @return list pet
     */
    @Override
    public List<PetResponse> getPetsByListId(List<Long> listId) {
        return petUseCase.getPetsByListId(listId);
    }
}