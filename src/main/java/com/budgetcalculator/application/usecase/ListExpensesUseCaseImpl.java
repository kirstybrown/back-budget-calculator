package com.budgetcalculator.application.usecase;

import com.budgetcalculator.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.application.repository.ExpenseRepository;
import com.budgetcalculator.domain.model.aggregate.Expense;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ListExpensesUseCaseImpl implements ListExpensesUseCase {

    private final ExpenseRepository expenseRepository;

    public ListExpensesUseCaseImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> findAll() {
        List<Expense> expenseList = StreamSupport
                .stream(this.expenseRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return expenseList;

    }

    @Override
    @Transactional(readOnly = true)
    public Expense findById(Long expenseId) {
        Optional<Expense> expense = this.expenseRepository.findById(expenseId);
        if(expense.isPresent()) {
            return this.expenseRepository.findById(expenseId).get();
        }
        return null;
    }

    @Override
    @Transactional
    public Expense create(Expense expense) {
        return this.expenseRepository.save(expense);
    }

    @Override
    @Transactional
    public Expense update(Expense updatedExpense, Long expenseId) {
        Optional<Expense> expense = this.expenseRepository.findById(expenseId);

        if(expense.isPresent()) {
            Expense expenseDB = expense.get();
            expenseDB.setName(updatedExpense.getName());
            expenseDB.setCurrency(updatedExpense.getCurrency());
            expenseDB.setAmount(updatedExpense.getAmount());
            expenseDB.setCategory(updatedExpense.getCategory());

            return this.expenseRepository.save(expenseDB);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long expenseId) {

        Optional<Expense> expense = this.expenseRepository.findById(expenseId);

        if(expense.isPresent()) {
            Expense expenseToDelete = expense.get();
            this.expenseRepository.delete(expenseToDelete);
        }
    }
}
