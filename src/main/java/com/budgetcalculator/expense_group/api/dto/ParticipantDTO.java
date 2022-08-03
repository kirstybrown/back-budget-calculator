package com.budgetcalculator.expense_group.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ParticipantDTO {

    private Long participantId;

    private String name;
}
