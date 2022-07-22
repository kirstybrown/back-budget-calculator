package com.budgetcalculator.expense_group.api;

import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

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
    public ResponseEntity<ExpenseEntity> create (@RequestBody ExpenseEntity expenseEntity) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.listExpensesUseCase.create(expenseEntity));
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
