package com.project.adoption.pet.api.controller;

import com.project.adoption.pet.api.handler.IPetHandler;
import com.project.adoption.pet.application.dto.PetRequest;
import com.project.adoption.pet.application.dto.PetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@RequiredArgsConstructor
public class PetController {
    private final IPetHandler petHandler;

    @Operation(summary = "Get pets available")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get pets available successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for get pets available", content = @Content)
    })
    @GetMapping("/mascotas-disponibles")
    public List<PetResponse> getAvailabilityPet(){
        return petHandler.getAvailabilityPet();
    }

    @Operation(summary = "Get pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get pet successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for get pet", content = @Content)
    })
    @GetMapping("/{id}")
    public PetResponse getPetById(@PathVariable Long id){
        return petHandler.getPet(id);
    }

    @Operation(summary = "Get pets by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get pets by list id successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for get pets by list id", content = @Content)
    })
    @GetMapping("/get-pets")
    public List<PetResponse> getAvailabilityPet(@RequestParam(name = "id") List<Long> listId){
        return petHandler.getPetsByListId(listId);
    }

    @Operation(summary = "Create a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a pet successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for create a pet", content = @Content)
    })
    @PostMapping()
    public String createPet(@RequestBody PetRequest petRequest){
        return petHandler.createPet(petRequest);
    }

    @Operation(summary = "Update a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update a pet successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for update a pet", content = @Content)
    })
    @PutMapping("/{id}")
    public String updatePet(@PathVariable Long id, @RequestBody PetRequest petRequest){
        return petHandler.updatePet(id, petRequest);
    }

    @Operation(summary = "Delete a pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a pet successfully", content = @Content),
            @ApiResponse(responseCode = "500", description = "Fail process for delete a pet", content = @Content)
    })
    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id){
        return petHandler.deletePet(id);
    }
}
