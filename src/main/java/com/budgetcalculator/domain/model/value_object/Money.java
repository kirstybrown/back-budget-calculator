package com.budgetcalculator.domain.model.value_object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Money {
    private Currency currency;
    private Double amount;
}
