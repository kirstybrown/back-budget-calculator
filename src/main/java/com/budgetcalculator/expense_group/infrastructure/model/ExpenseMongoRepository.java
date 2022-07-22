package com.budgetcalculator.expense_group.infrastructure.model;

import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseMongoRepository extends MongoRepository<ExpenseEntity, String> {
}
