package com.budgetcalculator.expense_group.application.repository;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate);

    Optional<Expense> findById(Long expenseId);

    Expense persist(Expense expense);

    void deleteExpenseById(ExpenseId expenseId);
}
