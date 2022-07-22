package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseIdEntity;
import com.budgetcalculator.expense_group.infrastructure.model.entity.ParticipantEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.CategoryEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.MoneyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
@RequiredArgsConstructor
public class ListExpensesUseCaseImpl implements ListExpensesUseCase {

    private final ExpenseRepository expenseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ExpenseEntity> findAll() {

        var expense = ExpenseEntity.builder()
                .expenseIdEntity(ExpenseIdEntity.builder().expenseId("id_1").build())
                .categoryEntity(CategoryEntity.OTHER)
                .isSettled(true)
                .moneyEntity(MoneyEntity.builder().amount(20.).currency("EURO").build())
                .payer(ParticipantEntity.builder().name("Fernando").build())
                .beneficiaries(Set.of(ParticipantEntity.builder().name("Kirsty").build()))
                .date(LocalDateTime.now())
                .build();

        var saved = expenseRepository.persist(expense);
        log.info("Expense saved = {}", saved);

        List<ExpenseEntity> expenseEntityList = expenseRepository.findAllExpenses();

        return expenseEntityList;
    }

    @Override
    @Transactional(readOnly = true)
    public ExpenseEntity findById(Long expenseId) {
        return null;
    }

    @Override
    @Transactional
    public ExpenseEntity create(ExpenseEntity expenseEntity) {
        return null;
    }

    @Override
    @Transactional
    public ExpenseEntity update(ExpenseEntity updatedExpenseEntity, Long expenseId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long expenseId) {

    }
}
