package org.example.service;

import org.example.dto.Expenses;
import org.example.dto.Group;
import org.example.dto.User;
import org.example.repository.ExpenseRepository;
import org.example.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository = new UserRepository();
    private final ExpenseRepository expenseRepository = new ExpenseRepository();
    public void createUser(String email, String phoneNumber) {
        User user = new User(email, phoneNumber);
        userRepository.addUser(user);
    }

    public void createGroup(List<String> userIds) {
        Group group = new Group(userIds);
    }

    public Double getGroupExpenseUser(String userId, String groupId) {
        // get all expenses belonging to the given groupId
        List<Expenses> expenses = expenseRepository.getExpenseForGroup(groupId);

        if(expenses.isEmpty()) return (double) 0;

        return expenses.stream().
                filter(expenses1 -> expenses1.getUserContriMap().containsKey(userId))
                .map(expenses1 -> expenses1.getUserContriMap().get(userId)).
                mapToDouble(Double::doubleValue).sum();
    }
}
