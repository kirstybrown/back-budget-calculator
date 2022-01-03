package com.budgetcalculator.budgetcalculatorapi.entity;

public class Expense {

    private Integer id;
    private String name;
    // private Integer money;
    // private Type type;
    // enum Type {FOOD, BILLS, TRANSPORT, RENT, PURCHASES, OTHER};

    public Expense(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Expense(Integer id) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
