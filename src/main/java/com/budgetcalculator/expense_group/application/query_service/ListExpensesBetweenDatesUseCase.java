package com.budgetcalculator.expense_group.application.query_service;

import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;

import java.util.List;

public interface ListExpensesBetweenDatesUseCase {

    List<ExpenseEntity> getExpensesBetweenDates();

}
