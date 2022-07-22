package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateExpenseUseCaseImpl implements CreateExpenseUseCase {

    @Override
    public void createExpense(Expense expense) {

    }
}
