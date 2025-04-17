package com.example.saypker.model.dto.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String gender;
    String breed;
    String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<Animal> animals;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
