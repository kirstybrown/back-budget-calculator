package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.command_service.UpdateExpenseUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateExpenseUseCaseImpl implements UpdateExpenseUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    public void updateExpense(Expense updatedExpense, Long expenseId) {

        Optional<Expense> expenseDB = expenseRepository.findById(expenseId);

        if(expenseDB.isPresent()) {
            expenseDB.get().setMoney(updatedExpense.getMoney());
            expenseDB.get().setCategory(updatedExpense.getCategory());
            expenseDB.get().setPayer(updatedExpense.getPayer());
            expenseDB.get().setBeneficiaries(updatedExpense.getBeneficiaries());
            expenseRepository.persist(expenseDB.get());
        }
    }
}
