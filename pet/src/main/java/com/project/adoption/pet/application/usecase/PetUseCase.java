package com.project.adoption.pet.application.usecase;

import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;
import com.project.adoption.pet.application.exception.PetTypeNotExistException;
import com.project.adoption.pet.application.mapper.IPetMapper;
import com.project.adoption.pet.domain.interfaces.IPetRepository;
import com.project.adoption.pet.domain.interfaces.IPetTypeService;
import com.project.adoption.pet.util.Constants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
public class PetUseCase implements IPetUseCase {
    private final IPetRepository petRepository;
    private final IPetMapper petMapper;
    private final IPetTypeService petTypeService;

    @Override
    public PetResponse getPet(Long petId) {
        return petMapper.toPetResponse(petRepository.getPet(petId));
    }

    @Override
    public String createPet(PetRequest petRequest) {
        if (petTypeService.validatePetType(petRequest.typePet())) {
            return petRepository.savePet(petMapper.toPet(petRequest));
        }
        throw new PetTypeNotExistException(String.format(Constants.MSG_PET_TYPE_NOT_EXIST, petRequest.typePet()));
    }

    @Override
    public String updatePet(Long petId, PetRequest petRequest) {
        return petRepository.updatePet(petId, petMapper.toPet(petRequest));
    }

    @Override
    public String deletePet(Long petId) {
        return petRepository.deletePet(petId);
    }

    /**
     * @return
     */
    @Override
    public List<PetResponse> getAvailabilityPet() {
        return petMapper.toPetResponseList(petRepository.getAvailabilityPet());
    }

    /**
     * @param listId
     * @return
     */
    @Override
    public List<PetResponse> getPetsByListId(List<Long> listId) {
        return petMapper.toPetResponseList(petRepository.getPetsByListId(listId));
    }
}