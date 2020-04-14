package com.hibicode.prepaid.adapter.out.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
public class AccountJpaEntity {

    @Id
    private String number;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountActivityJpaEntity> activities;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<AccountActivityJpaEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<AccountActivityJpaEntity> activities) {
        this.activities = activities;
    }

    public BigDecimal balance() {
        if (activities == null) {
            return BigDecimal.ZERO;
        }

        return activities
                .stream()
                .map(AccountActivityJpaEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountJpaEntity that = (AccountJpaEntity) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
