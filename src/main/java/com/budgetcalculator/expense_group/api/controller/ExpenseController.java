package com.budgetcalculator.expense_group.api.controller;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.api.mapper.ExpenseApiMapper;
import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

    private final CreateExpenseUseCase createExpenseUseCase;

    private final ExpenseApiMapper expenseApiMapper;

    @GetMapping
    public ResponseEntity<List<ExpenseEntity>> getExpenses() {

        return ResponseEntity.ok(listExpensesUseCase.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ExpenseEntity> getExpense(@PathVariable(value = "id") Long expenseId) {
        try {
            return ResponseEntity.ok(this.listExpensesUseCase.findById(expenseId));
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {

        var expense = expenseApiMapper.asExpense(expenseDTO);

        var expenseSaved = createExpenseUseCase.createExpense(expense);

        var expenseSavedDTO = expenseApiMapper.asExpenseDTO(expenseSaved);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expenseSavedDTO);
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<?> updateExpense(@RequestBody ExpenseDTO expenseDTO, @PathVariable(value = "id") Long expenseId) {

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable(value = "id") Long expenseId) {

        try {
            this.listExpensesUseCase.deleteById(expenseId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException error) {
            return ResponseEntity.notFound().build();
        }
    }
}
