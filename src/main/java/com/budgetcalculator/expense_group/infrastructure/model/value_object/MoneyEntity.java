package com.budgetcalculator.expense_group.infrastructure.model.value_object;

import lombok.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoneyEntity implements Serializable {

    private String currency;

    private Double amount;
}
