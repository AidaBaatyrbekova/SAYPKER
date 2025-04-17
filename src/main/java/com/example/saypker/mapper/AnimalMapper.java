package com.example.saypker.mapper;

import com.example.saypker.model.dto.entities.Animal;
import com.example.saypker.model.dto.entities.User;
import com.example.saypker.model.dto.request.AnimalRequest;
import com.example.saypker.model.dto.response.AnimalResponse;
import com.example.saypker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalMapper {

    private final UserRepository userRepository;

    public Animal mapToEntity(AnimalRequest request) {
        Animal animal = new Animal();
        animal.setName(request.getName());
        animal.setAge(request.getAge());
        animal.setBreed(request.getBreed());

        // User ID менен байланыштырабыз
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));
        animal.setUser(user);

        return animal;
    }

    public AnimalResponse mapToResponse(Animal animal) {
        return AnimalResponse.builder()
                .id(animal.getId())
                .name(animal.getName())
                .age(animal.getAge())
                .breed(animal.getBreed())
                .userId(animal.getUser().getId())
                .build();
    }

    public void updateEntityFromRequest(AnimalRequest request, Animal animal) {
        animal.setName(request.getName());
        animal.setAge(request.getAge());
        animal.setBreed(request.getBreed());

        // User өзгөрсө жаңыртабыз
        if (request.getUserId() != null && !request.getUserId().equals(animal.getUser().getId())) {
            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));
            animal.setUser(user);
        }
    }
}