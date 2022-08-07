package com.budgetcalculator.expense_group.api.controller;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.api.mapper.ExpenseApiMapper;
import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.application.command_service.DeleteExpenseUseCase;
import com.budgetcalculator.expense_group.application.command_service.UpdateExpenseUseCase;
import com.budgetcalculator.expense_group.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

    private final CreateExpenseUseCase createExpenseUseCase;

    private final UpdateExpenseUseCase updateExpenseUseCase;

    private final DeleteExpenseUseCase deleteExpenseUseCase;

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
    public ResponseEntity<Expense> updateExpense (@RequestBody ExpenseDTO expenseDTO, @PathVariable(value = "id") Long expenseId) {

        var expense = expenseApiMapper.asExpense(expenseDTO);

        updateExpenseUseCase.updateExpense(expense, expenseId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteExpense(@PathVariable(value = "id") String id) {

        log.info(id);

        ExpenseId expenseId = new ExpenseId(id);

        deleteExpenseUseCase.deleteExpenseById(expenseId);

        return ResponseEntity.ok()
                .build();
    }
}
