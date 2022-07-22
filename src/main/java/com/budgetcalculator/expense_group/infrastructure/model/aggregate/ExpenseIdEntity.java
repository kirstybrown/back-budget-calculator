package com.budgetcalculator.expense_group.infrastructure.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseIdEntity implements Serializable {

    private String expenseId;
}
