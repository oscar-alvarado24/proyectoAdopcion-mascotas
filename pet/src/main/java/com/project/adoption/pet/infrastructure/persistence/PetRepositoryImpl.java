package com.project.adoption.pet.infrastructure.persistence;

import com.project.adoption.pet.domain.entities.Pet;
import com.project.adoption.pet.domain.interfaces.IPetRepository;
import com.project.adoption.pet.infrastructure.exceptions.PetNotDeleteException;
import com.project.adoption.pet.infrastructure.exceptions.PetNotFoundException;
import com.project.adoption.pet.infrastructure.exceptions.PetNotGetException;
import com.project.adoption.pet.infrastructure.exceptions.PetNotSaveException;
import com.project.adoption.pet.infrastructure.exceptions.PetNotUpdatedException;
import com.project.adoption.pet.infrastructure.exceptions.PetsAvailabilityNotGetException;
import com.project.adoption.pet.infrastructure.exceptions.PetsNotGetException;
import com.project.adoption.pet.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class PetRepositoryImpl implements IPetRepository {

    private final PetJpaRepository jpaRepository;
    /**
     * @param pet
     * @return
     */
    @Override
    public String savePet(Pet pet) {
        try {
            Pet savedPet = jpaRepository.save(pet);
            return String.format(Constants.MSG_SAVE_SUCCESSFULLY, pet.getName(), savedPet.getId());
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new PetNotSaveException(String.format(Constants.MSG_PET_NOT_SAVE, pet.getName()));
        }
    }

    /**
     * @param id
     * @param pet
     * @return
     */
    @Override
    public String updatePet(Long id, Pet pet) {
        try {

            Optional<Pet> petSaved = jpaRepository.findById(id);
            Pet petUpdate;
            if (petSaved.isPresent()) {
                petUpdate = petSaved.get();
                petUpdate.setName(pet.getName());
                petUpdate.setAge(pet.getAge());
                petUpdate.setGender(pet.getGender());
                petUpdate.setAvailable(pet.isAvailable());
            } else {
                petUpdate = pet;
            }
            jpaRepository.save(petUpdate);
            return String.format(Constants.MSG_UPDATE_SUCCESSFULLY,id);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new PetNotUpdatedException(String.format(Constants.MSG_UPDATE_ERROR, id));
        }
    }

    /**
     * @param petId
     * @return
     */
    @Override
    public Pet getPet(Long petId) {
        try {
            return jpaRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(String.format(Constants.MSG_PET_NOT_FOUND, petId)));
        }
        catch (Exception exception){
            log.error(exception.getMessage());
            if(exception instanceof PetNotFoundException){
                throw exception;
            }
            throw new PetNotGetException(String.format(Constants.MSG_PET_NOT_GET, petId));
        }
    }

    /**
     * @param petId
     * @return
     */
    @Override
    public String deletePet(Long petId) {
        try {
            Pet petToDelete = jpaRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(String.format(Constants.MSG_PET_NOT_FOUND, petId)));
            petToDelete.setActive(Boolean.FALSE);
            jpaRepository.save(petToDelete);
            return String.format(Constants.MSG_PET_DELETE, petId);
        }catch (Exception exception){
            log.error(exception.getMessage());
            if(exception instanceof PetNotFoundException){
                throw exception;
            }
            throw new PetNotDeleteException(String.format(Constants.MSG_PET_NOT_DELETE, petId));
        }

    }

    /**
     * @return
     */
    @Override
    public List<Pet> getAvailabilityPet() {
        try {
            return jpaRepository.findByAvailable(Boolean.TRUE);
        } catch (Exception exception){
            log.error(exception.getMessage());
            throw new PetsAvailabilityNotGetException(Constants.MSG_PETS_AVAILABILITY_NOT_GET);
        }
    }

    /**
     * @param listId
     * @return
     */
    @Override
    public List<Pet> getPetsByListId(List<Long> listId) {
        try {
            return jpaRepository.findByIdIn(listId);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new PetsNotGetException(Constants.MSG_PETS_NOT_GET);
        }
    }
}
