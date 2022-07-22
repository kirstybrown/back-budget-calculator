package com.budgetcalculator.expense_group.application.query_service;

import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;

import java.util.List;

public interface ListExpensesUseCase {

    public List<ExpenseEntity> findAll();

    public ExpenseEntity findById(Long id);

    public ExpenseEntity create(ExpenseEntity expenseEntity);

    public ExpenseEntity update(ExpenseEntity updatedExpenseEntity, Long id);

    public void deleteById(Long expenseId);

}
