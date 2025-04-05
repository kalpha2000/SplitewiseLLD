package org.example.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String userId;
    String email;
    String phoneNumber;

    public User(String email, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
