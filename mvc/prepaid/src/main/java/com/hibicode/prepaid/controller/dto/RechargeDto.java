package com.hibicode.prepaid.controller.dto;

import java.math.BigDecimal;

public class RechargeDto {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
