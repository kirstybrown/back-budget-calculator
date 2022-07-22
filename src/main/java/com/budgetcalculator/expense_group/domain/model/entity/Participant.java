package com.budgetcalculator.expense_group.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant extends Entity {

    private Long participantId;

    private String name;
}
