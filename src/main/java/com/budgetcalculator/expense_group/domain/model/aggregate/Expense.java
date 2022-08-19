package com.budgetcalculator.expense_group.domain.model.aggregate;

import com.budgetcalculator.expense_group.domain.model.entity.Participant;
import com.budgetcalculator.expense_group.domain.model.value_object.Category;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.EnumUtils;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class Expense extends Aggregate {

    private ExpenseId expenseId;

    private Money money;

    private Category category;

    private LocalDateTime date;

    private Boolean isSettled;

    private Participant payer;

    private Set<Participant> beneficiaries;

    public Expense(ExpenseId expenseId, Money money, String category, Participant payer, Set<Participant> beneficiaries) {

        this.expenseId = expenseId;
        this.money = money;
        this.category = EnumUtils.getEnum(Category.class, category, Category.OTHER);
        this.date = LocalDateTime.now();
        this.isSettled = false;
        this.payer = payer;
        this.beneficiaries = beneficiaries;
    }

    public Expense(Money money, String category, Participant payer, Set<Participant> beneficiaries) {

        this.expenseId = new ExpenseId();
        this.money = money;
        this.category = EnumUtils.getEnum(Category.class, category, Category.OTHER);
        this.date = LocalDateTime.now();
        this.payer = payer;
        this.beneficiaries = beneficiaries;
    }

}
