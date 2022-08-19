package com.budgetcalculator.expense_group.application.usecase;

import com.budgetcalculator.expense_group.application.command_service.UpdateExpenseUseCase;
import com.budgetcalculator.expense_group.application.repository.ExpenseRepository;
import com.budgetcalculator.expense_group.domain.model.aggregate.Expense;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class UpdateExpenseUseCaseImplTest {

    @TestConfiguration
    static class TestContextConfiguration {

        @Bean
        public UpdateExpenseUseCase updateExpenseUseCase(final ExpenseRepository expenseRepository) {
            return new UpdateExpenseUseCaseImpl(expenseRepository);
        }
    }

    @MockBean
    private ExpenseRepository expenseRepository;

    @Autowired
    private UpdateExpenseUseCase updateExpenseUseCase;

    @Test
    void givenExpense_whenExpenseExists_thenUpdateExpense() {
        var expense = mock(Expense.class);
        var expenseDB = new Expense();
        var expenseId = 1L;

        when(expenseRepository.findById(expenseId))
                .thenReturn(Optional.of(expenseDB));

        updateExpenseUseCase.updateExpense(expense, expenseId);

        verify(expenseRepository).findById(expenseId);
        verify(expenseRepository).persist(expenseDB);
    }

}