package com.budgetcalculator.expense_group.application.command_service;

import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;

public interface DeleteExpenseUseCase {
    void deleteExpenseById(ExpenseId expenseId);
}
