package org.example.repository;

import org.example.dto.User;
import org.example.exceptions.SplitwiseException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserRepository implements Serializable {
    private static Map<String, User> userMap = new HashMap<>();

    public User getUserById(String userID) throws SplitwiseException {
        Optional<User> optionalUser = Optional.ofNullable(userMap.get(userID));
        if(optionalUser.isEmpty()) {
            throw new SplitwiseException("No such User present");
        }
        return optionalUser.get();
    }

    public void addUser(User user) {
        userMap.putIfAbsent(user.getUserId(), user);
    }
}
