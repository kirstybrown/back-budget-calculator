package com.budgetcalculator.expense_group.infrastructure.mapper;

import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;
import com.budgetcalculator.expense_group.domain.model.entity.Participant;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseIdEntity;
import com.budgetcalculator.expense_group.infrastructure.model.entity.ParticipantEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.CategoryEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.MoneyEntity;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ExpenseInfraMapper {

    public ExpenseEntity asExpenseEntity(Expense src) {

        Set<ParticipantEntity> beneficiaries = new HashSet<>();
        src.getBeneficiaries()
                .forEach(beneficiary -> beneficiaries
                        .add(ParticipantEntity.builder()
                                .participantId(beneficiary.getParticipantId())
                                .name(beneficiary.getName())
                                .build()));

        return ExpenseEntity.builder()
                .expenseId(ExpenseIdEntity.builder()
                        .expenseId(src.getExpenseId().getId())
                        .build())
                .money(MoneyEntity.builder()
                        .amount(src.getMoney().getAmount())
                        .currency(src.getMoney().getCurrency())
                        .build())
                .category(EnumUtils.getEnum(CategoryEntity.class, src.getCategory().name()))
                .date(src.getDate())
                .isSettled(src.getIsSettled())
                .payer(ParticipantEntity.builder()
                        .participantId(src.getPayer().getParticipantId())
                        .name(src.getPayer().getName())
                        .build())
                .beneficiaries(beneficiaries)
                .build();
    }

    public Expense asExpense(ExpenseEntity src) {

        var expenseId = new ExpenseId(src.getExpenseId().getExpenseId());

        var money = Money.builder()
                .amount(src.getMoney().getAmount())
                .currency(src.getMoney().getCurrency())
                .build();

        var category = src.getCategory().name();

        var payer = new Participant(src.getPayer().getParticipantId(), src.getPayer().getName());

        Set<Participant> beneficiaries = new HashSet<>();
        src.getBeneficiaries()
                .forEach(beneficiary -> beneficiaries
                        .add(new Participant(beneficiary.getParticipantId(), beneficiary.getName())));

        return new Expense(expenseId, money, category, payer, beneficiaries);
    }
}
