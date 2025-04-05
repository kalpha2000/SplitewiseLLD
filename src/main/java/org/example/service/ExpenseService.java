package org.example.service;

import org.example.dto.Expenses;
import org.example.exceptions.SplitwiseException;
import org.example.repository.ExpenseRepository;

import java.util.Date;

public class ExpenseService {

    private final ExpenseRepository expenseRepository = new ExpenseRepository();

    public void addExpense(Date createdDate, String groupId) {
        Expenses expenses = new Expenses(createdDate, groupId);
        expenseRepository.addExpense(expenses);
    }

    public void updateContribution(String expenseId, String userId, Double amount) throws SplitwiseException {
        Expenses expenses;
        try {
            expenses = expenseRepository.getExpense(expenseId);
        } catch (Exception e) {
            throw  new SplitwiseException("No expense found to update");
        }
        expenses.getUserContriMap().put(userId, amount);
    }

}
