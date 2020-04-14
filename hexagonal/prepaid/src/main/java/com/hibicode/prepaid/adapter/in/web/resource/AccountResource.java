package com.hibicode.prepaid.adapter.in.web.resource;

import java.math.BigDecimal;

public class AccountResource {

    private String number;
    private BigDecimal balance;

    public AccountResource(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
