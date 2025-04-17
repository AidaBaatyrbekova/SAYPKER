package com.example.saypker.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalResponse {
    private Long id;
    private String name;
    private int age;
    private String breed;
    private Long userId;
}