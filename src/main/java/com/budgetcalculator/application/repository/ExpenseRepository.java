package com.budgetcalculator.application.repository;

import com.budgetcalculator.domain.model.aggregate.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}
