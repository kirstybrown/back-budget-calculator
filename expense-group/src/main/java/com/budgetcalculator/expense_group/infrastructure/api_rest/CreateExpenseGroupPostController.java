package com.budgetcalculator.expense_group.infrastructure.api_rest;

import com.budgetcalculator.api.ExpenseGroupApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v0")
public class CreateExpenseGroupPostController implements ExpenseGroupApi {

    @Override
    public ResponseEntity<Void> createExpenseGroup() {
        return ResponseEntity.ok().build();
    }
}
