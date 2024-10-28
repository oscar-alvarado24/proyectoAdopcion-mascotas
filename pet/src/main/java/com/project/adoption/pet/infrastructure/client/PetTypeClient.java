package com.project.adoption.pet.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "moduloBClient", url = "${pet-type.service.url}")
public interface PetTypeClient {
    @GetMapping("/validate/{id}")
    public ResponseEntity<Boolean> validate(@PathVariable("id") Long id);
}
