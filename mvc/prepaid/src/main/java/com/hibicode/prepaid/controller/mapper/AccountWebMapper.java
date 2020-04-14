package com.hibicode.prepaid.controller.mapper;

import com.hibicode.prepaid.controller.dto.AccountDto;
import com.hibicode.prepaid.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountWebMapper {

    public AccountDto mapToResource(Account account) {
        return new AccountDto(account.getNumber(), account.balance());
    }

}
