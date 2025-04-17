package com.example.saypker.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalShortResponse {
    private Long id;
    private String name;
}
