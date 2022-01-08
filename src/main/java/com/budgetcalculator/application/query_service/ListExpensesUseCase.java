package com.budgetcalculator.application.query_service;

import com.budgetcalculator.domain.model.aggregate.Expense;

import java.util.List;
import java.util.Optional;

public interface ListExpensesUseCase {

    public List<Expense> findAll();

    public Expense findById(Long id);

    public Expense create(Expense expense);

    public Expense update(Expense updatedExpense, Long id);

}
