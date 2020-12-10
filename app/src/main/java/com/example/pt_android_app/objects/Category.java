package com.example.pt_android_app.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Category implements Serializable {
    private int id;

    private String name;
    private String description;

    private int fms_id;

    private Set<User> resUsers;
    private List<Income> incomeList;
    private List<Expense> expenses;

    private String createdOn;
    private String updatedOn;

    public Category() {
    }

    public Category(int id, String name, String description, int fms_id, Set<User> resUsers, List<Income> incomeList, List<Expense> expenses, String createdOn, String updatedOn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fms_id = fms_id;
        this.resUsers = resUsers;
        this.incomeList = incomeList;
        this.expenses = expenses;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFms_id() {
        return fms_id;
    }

    public void setFms_id(int fms_id) {
        this.fms_id = fms_id;
    }

    public Set<User> getResUsers() {
        return resUsers;
    }

    public void setResUsers(Set<User> resUsers) {
        this.resUsers = resUsers;
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List<Income> incomeList) {
        this.incomeList = incomeList;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return name;
    }
}
