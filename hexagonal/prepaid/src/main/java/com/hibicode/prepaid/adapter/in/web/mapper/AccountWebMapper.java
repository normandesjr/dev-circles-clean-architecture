package com.hibicode.prepaid.adapter.in.web.mapper;

import com.hibicode.prepaid.adapter.in.web.resource.AccountResource;
import com.hibicode.prepaid.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountWebMapper {

    public AccountResource mapToResource(Account account) {
        return new AccountResource(account.getNumber(), account.balance());
    }

}
