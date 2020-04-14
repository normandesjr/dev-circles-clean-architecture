package com.hibicode.prepaid.adapter.out.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "account_activity")
public class AccountActivityJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private AccountJpaEntity account;

    private BigDecimal amount;

    private LocalDateTime timestamp;

    public AccountActivityJpaEntity() {
    }

    public AccountActivityJpaEntity(AccountJpaEntity account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountJpaEntity getAccount() {
        return account;
    }

    public void setAccount(AccountJpaEntity account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountActivityJpaEntity that = (AccountActivityJpaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
