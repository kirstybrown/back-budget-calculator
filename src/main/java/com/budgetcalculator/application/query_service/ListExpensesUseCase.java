package com.budgetcalculator.application.query_service;

import com.budgetcalculator.domain.model.aggregate.Expense;

import java.util.List;

public interface ListExpensesUseCase {

    public List<Expense> listExpenses();

    public Expense findExpense(Long expenseId);
}
