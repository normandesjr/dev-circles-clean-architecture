package com.hibicode.prepaid.controller.dto;

import java.math.BigDecimal;

public class AccountDto {

    private String number;
    private BigDecimal balance;

    public AccountDto(String number, BigDecimal balance) {
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
