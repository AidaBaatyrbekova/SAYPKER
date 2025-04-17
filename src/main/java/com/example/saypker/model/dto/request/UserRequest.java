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
public class UserRequest {
  String name;
  String password;
  String email;
  String phone;
  String location;
 }

