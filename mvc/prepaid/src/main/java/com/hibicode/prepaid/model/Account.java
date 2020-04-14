package com.hibicode.prepaid.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private String number;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountActivity> activities;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<AccountActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<AccountActivity> activities) {
        this.activities = activities;
    }

    public BigDecimal balance() {
        if (activities == null) {
            return BigDecimal.ZERO;
        }

        return activities
                .stream()
                .map(AccountActivity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
