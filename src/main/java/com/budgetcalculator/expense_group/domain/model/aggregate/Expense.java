package com.budgetcalculator.expense_group.domain.model.aggregate;

import com.budgetcalculator.expense_group.domain.model.entity.Participant;
import com.budgetcalculator.expense_group.domain.model.value_object.Category;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends Aggregate {

    private ExpenseId expenseId;

    private Money moneyEntity;

    private Category categoryEntity;

    private LocalDateTime date;

    private Boolean isSettled;

    private Participant payer;

    private Set<Participant> beneficiaries;

}
