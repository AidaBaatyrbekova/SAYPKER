package com.example.saypker.service;

import com.example.saypker.model.dto.request.AnimalRequest;
import com.example.saypker.model.dto.response.AnimalResponse;

import java.util.List;

public interface AnimalService {

    AnimalResponse createAnimal(AnimalRequest request);

    AnimalResponse updateAnimal(Long id, AnimalRequest request);

    AnimalResponse getAnimalById(Long id);

    List<AnimalResponse> getAllAnimal();

    void deleteAnimal(Long id);
}
