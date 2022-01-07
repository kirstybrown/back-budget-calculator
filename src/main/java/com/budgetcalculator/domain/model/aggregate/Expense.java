package com.budgetcalculator.domain.model.aggregate;

import com.budgetcalculator.domain.model.value_object.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10)
    private String currency;

    @Column(nullable = false, length = 6)
    private Float amount;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

}
