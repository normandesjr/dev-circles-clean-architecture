package com.hibicode.prepaid.application.service.exception;

import java.math.BigDecimal;

public class ThresholdExceededException extends RuntimeException {

    public ThresholdExceededException(BigDecimal threshold, BigDecimal actual) {
        super(String.format("Maximum threshold for recharging exceeded: tried to recharge %s but threshold is %s!", actual, threshold));
    }
}
