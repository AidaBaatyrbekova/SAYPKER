package com.example.saypker.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location; // Жайгашкан жери
    private List<AnimalShortResponse> animals; // Жаныбарлар тизмеси
}