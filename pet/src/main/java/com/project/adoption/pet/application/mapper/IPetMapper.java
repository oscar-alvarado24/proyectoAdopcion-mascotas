package com.project.adoption.pet.application.mapper;

import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;
import com.project.adoption.pet.application.dto.TypeResponse;
import com.project.adoption.pet.domain.entities.Pet;
import com.project.adoption.pet.domain.entities.PetType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPetMapper {
    IPetMapper INSTANCE = Mappers.getMapper(IPetMapper.class);

    default Pet toPet(PetRequest petRequest){
        if(petRequest == null) return null;
        Pet pet = new Pet();
        pet.setActive(Boolean.TRUE);
        pet.setAvailable(Boolean.TRUE);
        pet.setAge(petRequest.age());
        pet.setName(petRequest.name());
        pet.setGender(petRequest.gender());
        pet.setType(new PetType(petRequest.typePet()));
        return pet;
    }
    default PetResponse toPetResponse(Pet pet){
        if(pet == null) return null;
        return PetResponse.builder()
                .id(pet.getId())
                .name(pet.getName())
                .age(pet.getAge())
                .gender(pet.getGender())
                .typePet(toTypeResponse(pet.getType()))
                .build();
    }

    TypeResponse toTypeResponse(PetType petType);

    List<PetResponse> toPetResponseList(List<Pet> pets);
}
