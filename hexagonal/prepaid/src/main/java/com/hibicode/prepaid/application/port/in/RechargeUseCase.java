package com.hibicode.prepaid.application.port.in;

import java.math.BigDecimal;

public interface RechargeUseCase {

    void recharge(String number, BigDecimal value);

}
