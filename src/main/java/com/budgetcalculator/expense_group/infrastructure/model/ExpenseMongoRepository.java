package com.budgetcalculator.expense_group.infrastructure.model;

import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseIdEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseMongoRepository extends MongoRepository<ExpenseEntity, String> {

    void deleteByExpenseId (ExpenseIdEntity expenseId);

    List<ExpenseEntity> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
