package org.example.repository;

import org.example.dto.Expenses;
import org.example.exceptions.SplitwiseException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExpenseRepository implements Serializable {
    public static LinkedList<Expenses> expensesList = new LinkedList<>();

    public void addExpense(Expenses expense) {
        expensesList.add(expense);
    }

    public Expenses getExpense(String expenseId) {
        Optional<Expenses> expenses = expensesList.
                stream().
                filter(expenses1 -> expenses1.getExpenseId().equals(expenseId)).
                findFirst();
        if(expenses.isEmpty()) {
            throw new SplitwiseException(String.format("No expense with id = {} found", expenseId));
        }
        return expenses.get();
    }

    public List<Expenses> getExpenseForGroup(String groupId) {
        return expensesList.stream()
                .filter(expenses -> expenses.getGroupId().equals(groupId))
                .collect(Collectors.toList());
    }
}
