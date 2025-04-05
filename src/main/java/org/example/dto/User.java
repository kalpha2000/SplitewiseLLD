package org.example.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String user;
    String email;
    String phoneNumber;
}
