package com.budgetcalculator.expense_group.application.repository;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    List<ExpenseEntity> findAllExpenses();

    Optional<Expense> findById(Long expenseId);

    Expense persist(Expense expense);
}
