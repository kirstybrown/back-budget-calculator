package com.budgetcalculator.expense_group.infrastructure.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "participants")
public class ParticipantEntity implements Serializable {

    @Id
    private Long participantId;

    private String name;
}
