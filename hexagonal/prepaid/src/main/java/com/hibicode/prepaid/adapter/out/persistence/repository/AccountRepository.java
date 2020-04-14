package com.hibicode.prepaid.adapter.out.persistence.repository;

import com.hibicode.prepaid.adapter.out.persistence.entity.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaEntity, String> {
}
