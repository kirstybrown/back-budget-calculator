package com.budgetcalculator.expense_group.application.command_service;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

public interface UpdateExpenseUseCase {

    void updateExpense(Expense updatedExpense, Long expenseId);
}
