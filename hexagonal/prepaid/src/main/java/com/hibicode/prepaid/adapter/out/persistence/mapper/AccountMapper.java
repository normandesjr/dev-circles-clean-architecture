package com.hibicode.prepaid.adapter.out.persistence.mapper;

import com.hibicode.prepaid.adapter.out.persistence.entity.AccountActivityJpaEntity;
import com.hibicode.prepaid.adapter.out.persistence.entity.AccountJpaEntity;
import com.hibicode.prepaid.domain.Account;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class AccountMapper {

    public Account mapToDomainEntity(AccountJpaEntity account) {
        return new Account(account.getNumber(), account.balance());
    }

    public AccountJpaEntity mapToJpaEntity(Account account) {
        AccountJpaEntity jpaEntity = new AccountJpaEntity();
        jpaEntity.setNumber(account.getNumber());
        jpaEntity.setActivities(account.getActivities()
                .stream()
                .map(activity -> new AccountActivityJpaEntity(jpaEntity, activity.getAmount()))
                .collect(toList()));
        return jpaEntity;
    }
}
