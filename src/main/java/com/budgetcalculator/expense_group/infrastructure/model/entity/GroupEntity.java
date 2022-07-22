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
@Document(collection = "groups")
public class GroupEntity implements Serializable {

    @Id
    private Long groupId;

    private String name;
}
