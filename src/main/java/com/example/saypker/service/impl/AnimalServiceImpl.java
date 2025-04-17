package com.example.saypker.service.impl;

import com.example.saypker.mapper.AnimalMapper;
import com.example.saypker.model.dto.entities.Animal;
import com.example.saypker.model.dto.request.AnimalRequest;
import com.example.saypker.model.dto.response.AnimalResponse;
import com.example.saypker.repository.AnimalRepository;
import com.example.saypker.service.AnimalService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class AnimalServiceImpl implements AnimalService {

    AnimalRepository animalRepository;
    AnimalMapper animalMapper;

    @Override
    public AnimalResponse createAnimal(AnimalRequest request) {
        Animal animal = animalMapper.mapToEntity(request);
        Animal savedAnimal = animalRepository.save(animal);
        return animalMapper.mapToResponse(savedAnimal);
    }

    @Override
    public AnimalResponse updateAnimal(Long id, AnimalRequest request) {
        Animal existingAnimal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
        animalMapper.updateEntityFromRequest(request, existingAnimal);
        Animal updatedAnimal = animalRepository.save(existingAnimal);
        return animalMapper.mapToResponse(updatedAnimal);
    }

    @Override
    public AnimalResponse getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
        return animalMapper.mapToResponse(animal);
    }

    @Override
    public List<AnimalResponse> getAllAnimal() {
        return animalRepository.findAll()
                .stream()
                .map(animalMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAnimal(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
        animalRepository.delete(animal);
    }
}