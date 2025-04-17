package com.example.saypker.mapper;

import com.example.saypker.model.dto.entities.User;
import com.example.saypker.model.dto.request.UserRequest;
import com.example.saypker.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setLocation(request.getLocation());
        return user;
    }

    public UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhone())
                .location(user.getLocation())
                .build();
    }

    public void updateEntityFromRequest(UserRequest request, User user) {
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setLocation(request.getLocation());
    }
}