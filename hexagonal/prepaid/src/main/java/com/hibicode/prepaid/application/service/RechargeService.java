package com.hibicode.prepaid.application.service;

import com.hibicode.prepaid.application.in.GetAccountQuery;
import com.hibicode.prepaid.application.port.in.RechargeUseCase;
import com.hibicode.prepaid.application.port.UpdateAccountPort;
import com.hibicode.prepaid.application.service.exception.NotFoundException;
import com.hibicode.prepaid.application.service.exception.ThresholdExceededException;
import com.hibicode.prepaid.domain.Account;
import com.hibicode.prepaid.domain.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RechargeService implements RechargeUseCase {

    @Value("${recharge.limit.value:100}")
    private BigDecimal limit;

    @Autowired
    private GetAccountQuery getAccountQuery;

    @Autowired
    private UpdateAccountPort updateAccount;

    @Override
    public void recharge(String number, BigDecimal value) {
        checkThreshold(value);

        Account account = getAccountQuery
                .getByNumber(number)
                .orElseThrow(NotFoundException::new);

        // More rules!
        account.recharge(new Recharge(value));
        updateAccount.update(account);
    }

    private void checkThreshold(BigDecimal value) {
        if (limit.compareTo(value) < 0) {
            throw new ThresholdExceededException(limit, value);
        }
    }

}
