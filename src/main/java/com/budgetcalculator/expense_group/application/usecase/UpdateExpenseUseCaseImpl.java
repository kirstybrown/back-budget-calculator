package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.command_service.UpdateExpenseUseCase;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import org.springframework.stereotype.Service;

@Service
public class UpdateExpenseUseCaseImpl implements UpdateExpenseUseCase {

    @Override
    public void updateExpense(Expense updatedExpense, Long expenseId) {

    }
}
