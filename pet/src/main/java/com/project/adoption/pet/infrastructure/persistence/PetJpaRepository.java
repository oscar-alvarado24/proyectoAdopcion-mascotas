package com.project.adoption.pet.infrastructure.persistence;

import com.project.adoption.pet.domain.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetJpaRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByAvailable(boolean aTrue);

    List<Pet> findByIdIn(List<Long> listId);
}

