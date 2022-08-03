package com.budgetcalculator.expense_group.api.controller;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.api.mapper.ExpenseApiMapper;
import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

    private final CreateExpenseUseCase createExpenseUseCase;

    private final ExpenseApiMapper expenseApiMapper;

    @GetMapping
    public ResponseEntity<List<ExpenseEntity>> readAll() {
        return ResponseEntity.ok(listExpensesUseCase.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExpenseEntity> read (@PathVariable(value = "id") Long expenseId) {
        try {
            return ResponseEntity.ok(this.listExpensesUseCase.findById(expenseId));
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ExpenseEntity> create (@RequestBody ExpenseDTO expenseDTO) {

        var expense = expenseApiMapper.asExpense(expenseDTO);

        createExpenseUseCase.createExpense(expense);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<?> update (@RequestBody ExpenseEntity updatedExpenseEntity, @PathVariable(value = "id") Long expenseId) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.listExpensesUseCase.update(updatedExpenseEntity, expenseId));
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") Long expenseId) {

        try {
            this.listExpensesUseCase.deleteById(expenseId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }
}
