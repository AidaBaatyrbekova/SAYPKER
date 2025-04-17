package com.example.saypker.model.dto.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
@Table(name = "users")
@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phone;
    String password;
    String location;
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Animal> animals = new ArrayList<>();
}
