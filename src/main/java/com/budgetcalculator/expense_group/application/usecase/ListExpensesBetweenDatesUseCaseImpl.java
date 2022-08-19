package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.query_service.ListExpensesBetweenDatesUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListExpensesBetweenDatesUseCaseImpl implements ListExpensesBetweenDatesUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate) {

        return expenseRepository.getExpensesBetweenDates(startDate, endDate);
    }
}
