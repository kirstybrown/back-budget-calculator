package com.budgetcalculator.expense_group.api.mapper;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

import java.util.List;

public interface ExpenseApiMapper {

    Expense asExpense(ExpenseDTO src);

    ExpenseDTO asExpenseDTO(Expense expense);

    List<ExpenseDTO> asExpenseDTOs(List<Expense> expenses);
}
