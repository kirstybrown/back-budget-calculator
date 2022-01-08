package com.budgetcalculator.api;

import com.budgetcalculator.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.domain.model.aggregate.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

    public ExpenseController(ListExpensesUseCase listExpensesUseCase) {
        this.listExpensesUseCase = listExpensesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> readAll() {
        return ResponseEntity.ok(this.listExpensesUseCase.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> read (@PathVariable(value = "id") Long expenseId) {
        try {
            return ResponseEntity.ok(this.listExpensesUseCase.findById(expenseId));
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody Expense expense) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.listExpensesUseCase.create(expense));
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<?> update (@RequestBody Expense updatedExpense, @PathVariable(value = "id") Long expenseId) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.listExpensesUseCase.update(updatedExpense, expenseId));
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

}
