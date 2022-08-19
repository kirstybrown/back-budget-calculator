package com.budgetcalculator.expense_group.application.usecase;
import com.budgetcalculator.expense_group.application.command_service.DeleteExpenseUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteExpenseUseCaseImpl implements DeleteExpenseUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {

        expenseRepository.deleteExpenseById(expenseId);
    }
}
