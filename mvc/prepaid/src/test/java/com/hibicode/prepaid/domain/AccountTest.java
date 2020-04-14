package com.hibicode.prepaid.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    @Test
    public void should_recharge() {
        Account account = new Account("1", BigDecimal.ZERO);
        account.recharge(new Recharge(BigDecimal.TEN));
        account.recharge(new Recharge(BigDecimal.ONE));

        assertEquals(new BigDecimal("11"), account.balance());
    }

    @Test
    public void should_return_zero_no_recharge() {
        Account account = new Account("1", BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, account.balance());
    }

    @Test
    public void should_consume_and_keep_some_money() {
        Account account = new Account("1", BigDecimal.ZERO);
        account.recharge(new Recharge(BigDecimal.TEN));

        assertEquals(true, account.consume(new BigDecimal("4")));
        assertEquals(new BigDecimal("6"), account.balance());
    }

    @Test
    public void should_not_allow_consume() {
        Account account = new Account("1", BigDecimal.ZERO);
        account.recharge(new Recharge(BigDecimal.TEN));

        assertEquals(false, account.consume(new BigDecimal("40")));
        assertEquals(BigDecimal.TEN, account.balance());
    }

    @Test
    public void should_allow_consume_all_balance() {
        Account account = new Account("1", BigDecimal.ZERO);
        account.recharge(new Recharge(BigDecimal.TEN));

        assertEquals(true, account.consume(BigDecimal.TEN));
        assertEquals(BigDecimal.ZERO, account.balance());
    }

}
