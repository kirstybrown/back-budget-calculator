package com.budgetcalculator.expense_group.api.mapper;

import com.budgetcalculator.expense_group.api.dto.CategoryEnumDTO;
import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.api.dto.ParticipantDTO;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.entity.Participant;
import com.budgetcalculator.expense_group.domain.model.value_object.Money;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ExpenseApiMapperImpl implements ExpenseApiMapper {

    @Override
    public Expense asExpense(ExpenseDTO src) {

        var money = Money.builder()
                .amount(src.getAmount())
                .currency(src.getCurrency())
                .build();

        var category = src.getCategory().name();

        var payer = new Participant(src.getPayer().getParticipantId(), src.getPayer().getName());

        Set<Participant> beneficiaries = new HashSet<>();
        src.getBeneficiaries()
                .forEach(beneficiary -> beneficiaries
                        .add(new Participant(beneficiary.getParticipantId(), beneficiary.getName())));

        return new Expense(money, category, payer, beneficiaries);
    }

    @Override
    public ExpenseDTO asExpenseDTO(Expense src) {

        Set<ParticipantDTO> beneficiaries = new HashSet<>();
        src.getBeneficiaries()
                .forEach(beneficiary -> beneficiaries
                        .add(ParticipantDTO.builder()
                                .participantId(beneficiary.getParticipantId())
                                .name(beneficiary.getName())
                                .build()));

        return ExpenseDTO.builder()
                .expenseId(src.getExpenseId().getId())
                .currency(src.getMoney().getCurrency())
                .amount(src.getMoney().getAmount())
                .category(EnumUtils.getEnum(CategoryEnumDTO.class, src.getCategory().name()))
                .date(src.getDate())
                .isSettled(src.getIsSettled())
                .payer(ParticipantDTO.builder()
                        .participantId(src.getPayer().getParticipantId())
                        .name(src.getPayer().getName())
                        .build())
                .beneficiaries(beneficiaries)
                .build();
    }

    public List<ExpenseDTO> asExpenseDTOs(List<Expense> expenses) {

        return expenses.stream()
                .map(this::asExpenseDTO)
                .toList();
    }
}
