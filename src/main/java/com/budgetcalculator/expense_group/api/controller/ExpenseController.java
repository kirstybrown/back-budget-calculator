package com.budgetcalculator.expense_group.api.controller;

import com.budgetcalculator.expense_group.api.dto.ExpenseDTO;
import com.budgetcalculator.expense_group.api.mapper.ExpenseApiMapper;
import com.budgetcalculator.expense_group.application.command_service.CreateExpenseUseCase;
import com.budgetcalculator.expense_group.application.command_service.DeleteExpenseUseCase;
import com.budgetcalculator.expense_group.application.command_service.UpdateExpenseUseCase;
import com.budgetcalculator.expense_group.application.query_service.ListExpensesBetweenDatesUseCase;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import com.budgetcalculator.expense_group.domain.model.aggregate.ExpenseId;
import com.budgetcalculator.expense_group.infrastructure.model.aggregate.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesBetweenDatesUseCase listExpensesBetweenDatesUseCase;

    private final CreateExpenseUseCase createExpenseUseCase;

    private final UpdateExpenseUseCase updateExpenseUseCase;

    private final DeleteExpenseUseCase deleteExpenseUseCase;

    private final ExpenseApiMapper expenseApiMapper;

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> listExpensesBetweenDates(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        var expenses = listExpensesBetweenDatesUseCase.getExpensesBetweenDates(startDate, endDate);

        var expenseDTOs = expenseApiMapper.asExpenseDTOs(expenses);

        return ResponseEntity.ok().body(expenseDTOs);
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
    public ResponseEntity<Expense> updateExpense (
            @RequestBody ExpenseDTO expenseDTO, @PathVariable(value = "id") Long expenseId) {

        var expense = expenseApiMapper.asExpense(expenseDTO);

        updateExpenseUseCase.updateExpense(expense, expenseId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable(value = "id") String id) {

        log.info(id);

        ExpenseId expenseId = new ExpenseId(id);

        deleteExpenseUseCase.deleteExpenseById(expenseId);

        return ResponseEntity.ok()
                .build();
    }
}
