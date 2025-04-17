package com.example.saypker.controller;

import com.example.saypker.model.dto.request.AnimalRequest;
import com.example.saypker.model.dto.response.AnimalResponse;
import com.example.saypker.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalResponse> create(@RequestBody AnimalRequest request) {
        AnimalResponse response = animalService.createAnimal(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> update(@PathVariable Long id,
                                                 @RequestBody AnimalRequest request) {
        AnimalResponse response = animalService.updateAnimal(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> getById(@PathVariable Long id) {
        AnimalResponse response = animalService.getAnimalById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> getAll() {
        List<AnimalResponse> animals = animalService.getAllAnimal();
        return ResponseEntity.ok(animals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}

