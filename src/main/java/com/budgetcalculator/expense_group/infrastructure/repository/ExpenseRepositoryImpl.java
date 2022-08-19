package com.budgetcalculator.expense_group.infrastructure.repository;

import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;
import com.budgetcalculator.expense_group.infrastructure.mapper.ExpenseInfraMapper;
import com.budgetcalculator.expense_group.infrastructure.model.ExpenseMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseInfraMapper expenseInfraMapper;

    private final ExpenseMongoRepository expenseMongoRepository;

    @Override
    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate) {
        var expenseEntities = expenseMongoRepository.findByDateBetween(startDate, endDate);

        return expenseInfraMapper.asExpenses(expenseEntities);
    }

    @Override
    public Optional<Expense> findById(Long expenseId) {
        return Optional.empty();
    }

    @Override
    public Expense persist(Expense expense) {
        var expenseEntity = expenseInfraMapper.asExpenseEntity(expense);

        var expenseEntityDB = expenseMongoRepository.save(expenseEntity);

        return expenseInfraMapper.asExpense(expenseEntityDB);
    }

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {

        var expenseIdEntity = expenseInfraMapper.asExpenseIdEntity(expenseId);

        expenseMongoRepository.deleteByExpenseId(expenseIdEntity);
    }
}
