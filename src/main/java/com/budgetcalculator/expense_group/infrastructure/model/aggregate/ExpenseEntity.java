package com.budgetcalculator.expense_group.infrastructure.model.aggregate;

import com.budgetcalculator.expense_group.infrastructure.model.entity.ParticipantEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.CategoryEntity;
import com.budgetcalculator.expense_group.infrastructure.model.value_object.MoneyEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "expenses")
public class ExpenseEntity implements Serializable {

    @Id
    private String id;

    private ExpenseIdEntity expenseIdEntity;

    private MoneyEntity moneyEntity;

    private CategoryEntity categoryEntity;

    private LocalDateTime date;

    private Boolean isSettled;

    private ParticipantEntity payer;

    private Set<ParticipantEntity> beneficiaries;

}
