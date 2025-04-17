package com.example.saypker.model.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Data
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalRequest {
    String name;
    int age;
    String gender;
    String breed;
    String description;
    Long userId;
}
