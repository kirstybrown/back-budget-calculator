package com.budgetcalculator.api;

import com.budgetcalculator.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.domain.model.aggregate.Expense;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/expenses")
public class ExpenseController {

    private final ListExpensesUseCase listExpensesUseCase;

    public ExpenseController(ListExpensesUseCase listExpensesUseCase) {
        this.listExpensesUseCase = listExpensesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(this.listExpensesUseCase.listExpenses());
    }

}
