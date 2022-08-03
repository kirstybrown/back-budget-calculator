package com.budgetcalculator.expense_group.application.command_service;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

public interface CreateExpenseUseCase {

    Expense createExpense(Expense expense);
}
