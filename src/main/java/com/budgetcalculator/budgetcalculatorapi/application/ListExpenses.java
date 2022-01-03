package com.budgetcalculator.budgetcalculatorapi.application;

import com.budgetcalculator.budgetcalculatorapi.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ListExpenses {

    private List<Expense> expenses;

    public ListExpenses() {
        expenses = new ArrayList<Expense>(Collections.emptyList());
        Expense expense1 = new Expense(1, "mercadona");
        Expense expense2 = new Expense(2, "internet");
        expenses.add(expense1);
        expenses.add(expense2);
    }

    public List<Expense> mockListExpensesRepository(Integer id) {
        Expense response;

        switch(id) {
            case 1:
                response = new Expense (1, "Pizza");
                break;

            case 2:
                response = new Expense (2, "Diesel");
                break;

            default:
                response = null;
                break;
        }
        return (List<Expense>) response;
    }
}
