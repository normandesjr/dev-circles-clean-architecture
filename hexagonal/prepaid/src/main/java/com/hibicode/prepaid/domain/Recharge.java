package com.hibicode.prepaid.domain;

import java.math.BigDecimal;

public class Recharge {

    private BigDecimal amount;

    public Recharge(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
