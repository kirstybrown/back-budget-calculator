package com.budgetcalculator.expense_group.infrastructure.repository;

import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.infrastructure.model.ExpenseMongoRepository;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseMongoRepository expenseMongoRepository;

    @Override
    public List<ExpenseEntity> findAllExpenses() {
        return expenseMongoRepository.findAll();
    }

    @Override
    public ExpenseEntity persist(ExpenseEntity expenseEntity) {
        return expenseMongoRepository.save(expenseEntity);
    }
}
