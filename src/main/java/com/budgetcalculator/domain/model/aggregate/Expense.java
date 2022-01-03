package com.budgetcalculator.domain.model.aggregate;

import com.budgetcalculator.domain.model.value_object.Category;
import com.budgetcalculator.domain.model.value_object.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private Long id;
    private String name;
    private Money money;
    private Category category;

}
