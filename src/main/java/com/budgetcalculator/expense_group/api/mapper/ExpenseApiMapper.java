package com.budgetcalculator.expense_group.api.mapper;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;

public interface ExpenseApiMapper {

    Expense asExpense(ExpenseDTO src);
}
