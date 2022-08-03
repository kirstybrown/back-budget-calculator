package com.budgetcalculator.expense_group.application.command_service;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

public interface CreateExpenseUseCase {

    void createExpense(Expense expense);
}
