package com.budgetcalculator.expense_group.domain.model.aggregate;

import com.budgetcalculator.expense_group.domain.model.entity.Participant;
import com.budgetcalculator.expense_group.domain.model.value_object.Category;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends Aggregate {

    private ExpenseId expenseId;

    private Money money;

    private Category category;

    private LocalDateTime date;

    private Boolean isSettled;

    private Participant payer;

    private Set<Participant> beneficiaries;

    public Expense(Money money, String category, Long payerId, Set<Long> beneficiaries) {

        this.money = money;
        this.category = EnumUtils.getEnum(Category.class, category, Category.OTHER);
        this.date = LocalDateTime.now();
    }

}
