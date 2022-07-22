package com.budgetcalculator.expense_group.application.repository;

import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;

import java.util.List;

public interface ExpenseRepository {

    List<ExpenseEntity> findAllExpenses();

    ExpenseEntity persist(ExpenseEntity expenseEntity);
}
