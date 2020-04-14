package com.hibicode.prepaid.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String number;
    private BigDecimal initialBalance;
    private List<AccountActivity> activities = new ArrayList<>();

    public Account(String number, BigDecimal initialBalance) {
        this.number = number;
        this.initialBalance = initialBalance;
    }

    public String getNumber() {
        return number;
    }

    public List<AccountActivity> getActivities() {
        return activities;
    }

    public BigDecimal balance() {
        return activities.stream()
                .map(AccountActivity::getAmount)
                .reduce(initialBalance, BigDecimal::add);
    }

    public void recharge(Recharge recharge) {
        activities.add(new AccountActivity(recharge.getAmount()));
    }

    public boolean consume(BigDecimal value) {
        if (!hasEnoughBalance(value)) {
            return false;
        }

        activities.add(new AccountActivity(value.negate()));

        return true;
    }

    private boolean hasEnoughBalance(BigDecimal value) {
        return balance().compareTo(value) >= 0;
    }

}
