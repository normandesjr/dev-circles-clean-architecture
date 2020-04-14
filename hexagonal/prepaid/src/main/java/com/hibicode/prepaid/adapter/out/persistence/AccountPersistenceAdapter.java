package com.hibicode.prepaid.adapter.out.persistence;

import com.hibicode.prepaid.adapter.out.persistence.mapper.AccountMapper;
import com.hibicode.prepaid.adapter.out.persistence.repository.AccountRepository;
import com.hibicode.prepaid.application.port.in.GetAccountQuery;
import com.hibicode.prepaid.application.port.out.UpdateAccountPort;
import com.hibicode.prepaid.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountPersistenceAdapter implements UpdateAccountPort, GetAccountQuery {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Optional<Account> getByNumber(String number) {
        return accountRepository
                .findById(number)
                .map(accountMapper::mapToDomainEntity);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(accountMapper.mapToJpaEntity(account));
    }

}
