package com.budgetcalculator.expense_group.domain.model.value_object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Money extends ValueObject {

    private String currency;

    private Double amount;
}
