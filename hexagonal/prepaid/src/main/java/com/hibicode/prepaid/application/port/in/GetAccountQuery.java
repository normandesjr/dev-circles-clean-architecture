package com.hibicode.prepaid.application.port.in;

import com.hibicode.prepaid.domain.Account;

import java.util.Optional;

public interface GetAccountQuery {

    Optional<Account> getByNumber(String number);

}
