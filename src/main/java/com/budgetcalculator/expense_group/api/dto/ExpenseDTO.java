package com.budgetcalculator.expense_group.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private String id;

    private String currency;

    private Double amount;

    private String category;

    private Long participantId;

    private Set<Long> beneficiaries;
}
