package com.hibicode.prepaid.repository;

import com.hibicode.prepaid.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
