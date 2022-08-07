package com.budgetcalculator.expense_group.domain.model.aggregate;

import lombok.Data;

import java.util.Random;

@Data
public class ExpenseId extends Aggregate {

    private String id;

    public ExpenseId() {
        this.id = "ID-".concat(String.valueOf(getRandomNumberUsingNextInt(1, 9999)));
    }

    public ExpenseId(String id) {
        this.id = id;
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
