package com.budgetcalculator.budgetcalculatorapi.api;

import com.budgetcalculator.budgetcalculatorapi.application.ListExpenses;
import com.budgetcalculator.budgetcalculatorapi.entity.Expense;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/expense")
public class ExpenseController {

    private ListExpenses listExpenses;

    public ExpenseController(ListExpenses listExpenses) {
        this.listExpenses = listExpenses;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable(value = "id") Integer id) {
        Expense response;
        response = new Expense(1, "mercadona");
        // response = (Expense) this.listExpenses.mockListExpensesRepository(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

}
