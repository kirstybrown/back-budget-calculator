package com.budgetcalculator.expense_group.api.mapper;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;

public class ExpenseApiMapperImpl implements ExpenseApiMapper {

    @Override
    public Expense asExpense(ExpenseDTO src) {

        var money = Money.builder()
                .amount(src.getAmount())
                .currency(src.getCurrency())
                .build();

        return new Expense(
                money,
                src.getCategory(),
                src.getParticipantId(),
                src.getBeneficiaries());
    }
}
