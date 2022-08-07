package com.budgetcalculator.expense_group.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class ExpenseDTO {

    private String expenseId;

    private String currency;

    private Double amount;

    private CategoryEnumDTO category;

    private LocalDateTime date;

    private Boolean isSettled;

    private ParticipantDTO payer;

    private Set<ParticipantDTO> beneficiaries;
}
