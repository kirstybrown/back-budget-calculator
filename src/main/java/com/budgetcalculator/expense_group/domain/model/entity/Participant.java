package com.budgetcalculator.expense_group.domain.model.entity;

import lombok.Data;

@Data
public class Participant extends Entity {

    private Long participantId;

    private String name;

    public Participant(Long participantId, String name) {

        this.participantId = participantId;
        this.name = name;
    }
}
