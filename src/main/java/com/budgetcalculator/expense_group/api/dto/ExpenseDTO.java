package com.budgetcalculator.expense_group.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
public class ExpenseDTO {

    private String expenseIdEntity;

    private String currency;

    private Double amount;

    private CategoryEnumDTO categoryEntity;

    private LocalDateTime date;

    private Boolean isSettled;

    private ParticipantDTO payer;

    private Set<ParticipantDTO> beneficiaries;
}
