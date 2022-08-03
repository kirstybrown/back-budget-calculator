package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateExpenseUseCaseImpl implements CreateExpenseUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    public Expense createExpense(Expense expense) {
        log.info("createExpense");

        return expenseRepository.persist(expense);
    }
}
