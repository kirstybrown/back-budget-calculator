package com.budgetcalculator.expense_group.application.query_service;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ListExpensesBetweenDatesUseCase {

    List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate);

}
