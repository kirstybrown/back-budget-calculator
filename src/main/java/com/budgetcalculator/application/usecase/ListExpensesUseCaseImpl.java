package com.budgetcalculator.application.usecase;

import com.budgetcalculator.application.query_service.ListExpensesUseCase;
import com.budgetcalculator.domain.model.aggregate.Expense;
import com.budgetcalculator.domain.model.value_object.Category;
import com.budgetcalculator.domain.model.value_object.Currency;
import com.budgetcalculator.domain.model.value_object.Money;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ListExpensesUseCaseImpl implements ListExpensesUseCase {

    @Override
    public List<Expense> listExpenses() {
        return mockFindAllExpensesInDatabase().orElse(new ArrayList<>());
    }

    @Override
    public Expense findExpense(Long expenseId) {
        return mockFindExpenseByIdInDatabase(expenseId).orElse(null);
    }

    public Optional<Expense> mockFindExpenseByIdInDatabase(Long expenseId) {
        Expense expense;

        if (expenseId == 1) {
            expense = new Expense(1L, "pizza",
                    new Money(Currency.EURO, 10.5),
                    Category.FOOD);
        } else if (expenseId == 2) {
            expense = new Expense(2L, "diesel",
                    new Money(Currency.EURO, 80.1),
                    Category.TRANSPORT);
        } else {
            expense = null;
        }

        return Optional.of(expense);
    }

    public Optional<List<Expense>> mockFindAllExpensesInDatabase() {
        List<Expense> listExpenses = new ArrayList<>();
        listExpenses.add(new Expense(
                1L,
                "pizza",
                new Money(Currency.EURO, 10.5),
                Category.FOOD));
        listExpenses.add(new Expense(
                2L,
                "diesel",
                new Money(Currency.EURO, 80.1),
                Category.TRANSPORT));
        return Optional.of(listExpenses);
    }
}
