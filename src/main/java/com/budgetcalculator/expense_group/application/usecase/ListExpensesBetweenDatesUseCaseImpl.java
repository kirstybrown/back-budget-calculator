package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.query_service.ListExpensesBetweenDatesUseCase;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListExpensesBetweenDatesUseCaseImpl implements ListExpensesBetweenDatesUseCase {

    @Override
    public List<ExpenseEntity> getExpensesBetweenDates() {
        return null;
    }
}
