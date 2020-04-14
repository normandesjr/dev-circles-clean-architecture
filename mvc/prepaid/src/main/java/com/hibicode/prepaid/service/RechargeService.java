package com.hibicode.prepaid.service;

import com.hibicode.prepaid.model.Account;
import com.hibicode.prepaid.model.AccountActivity;
import com.hibicode.prepaid.repository.AccountRepository;
import com.hibicode.prepaid.service.exception.NotFoundException;
import com.hibicode.prepaid.service.exception.ThresholdExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RechargeService {

    @Value("${recharge.limit.value:100}")
    private BigDecimal limit;

    @Autowired
    private AccountRepository accountRepository;

    public void recharge(String number, BigDecimal value) {
        checkThreshold(value);

        Account account = accountRepository
                .findById(number)
                .orElseThrow(NotFoundException::new);

        List<AccountActivity> accountActivities = account.getActivities();
        if (accountActivities == null) {
            accountActivities = new ArrayList<>();
        }

        AccountActivity newRecharge = new AccountActivity(account, value);
        accountActivities.add(newRecharge);

        // More rules!
        accountRepository.save(account);
    }

    private void checkThreshold(BigDecimal value) {
        if (limit.compareTo(value) < 0) {
            throw new ThresholdExceededException(limit, value);
        }
    }

}
