package com.budgetcalculator.expense_group.domain.model.value_object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends ValueObject {

    private CategoryEnum category;

    public enum CategoryEnum {
        OTHER,
        FOOD,
        BILLS,
        TRANSPORT,
        RENT,
        PURCHASES
    }
}


