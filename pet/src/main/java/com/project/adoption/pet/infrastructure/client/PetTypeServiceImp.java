package com.project.adoption.pet.infrastructure.client;

import com.project.adoption.pet.domain.interfaces.IPetTypeService;
import com.project.adoption.pet.infrastructure.exceptions.InternalErrorInPetTypeException;
import com.project.adoption.pet.infrastructure.exceptions.NotCommunicateWithPetTypeException;
import com.project.adoption.pet.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PetTypeServiceImp implements IPetTypeService {
    private final PetTypeClient petTypeClient;
    /**
     * @param petTypeId of  pet-type to assign to the pet
     * @return boolean indicate if exist or not
     */
    @Override
    public boolean validatePetType(Long petTypeId) {
        try {
            ResponseEntity<Boolean> response = petTypeClient.validate(petTypeId);
            if(response.getStatusCode().is2xxSuccessful()){
                return Boolean.TRUE.equals(response.getBody());
            }
            throw new InternalErrorInPetTypeException(Constants.INTERNAL_ERROR_IN_PET_TYPE);
        } catch (Exception exception) {
            if (exception instanceof InternalErrorInPetTypeException) {
                throw exception;
            }
            log.error(exception.getMessage());
            throw new NotCommunicateWithPetTypeException(Constants.MSG_NOT_COMMUNICATE_WITH_PET_TYPE);
        }
    }
}
