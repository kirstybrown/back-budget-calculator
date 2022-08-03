package com.budgetcalculator.expense_group.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDTO {

    private Long participantId;

    private String name;
}
