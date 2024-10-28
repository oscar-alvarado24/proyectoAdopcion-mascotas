package com.project.adoption.pet.infrastructure.configuration;

import com.project.adoption.pet.domain.interfaces.IPetRepository;
import com.project.adoption.pet.domain.interfaces.IPetTypeService;
import com.project.adoption.pet.infrastructure.client.PetTypeClient;
import com.project.adoption.pet.infrastructure.client.PetTypeServiceImp;
import com.project.adoption.pet.infrastructure.persistence.PetJpaRepository;
import com.project.adoption.pet.infrastructure.persistence.PetRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfigurtation {
    private final PetJpaRepository petJpaRepository;
    private final PetTypeClient petTypeClient;

    @Bean
    public IPetRepository petRepository() {
        return new PetRepositoryImpl(petJpaRepository);
    }

    @Bean
    public IPetTypeService petTypeService(){
        return new PetTypeServiceImp(petTypeClient);
    }
}
