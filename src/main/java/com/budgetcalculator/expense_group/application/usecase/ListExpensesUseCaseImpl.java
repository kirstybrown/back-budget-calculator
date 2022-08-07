package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ListExpensesUseCaseImpl implements ListExpensesUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseEntity> findAll() {
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public ExpenseEntity findById(Long expenseId) {
        return null;
    }

    @Override
    @Transactional
    public ExpenseEntity update(ExpenseEntity updatedExpenseEntity, Long expenseId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long expenseId) {
        throw new UnsupportedOperationException();
    }
}
