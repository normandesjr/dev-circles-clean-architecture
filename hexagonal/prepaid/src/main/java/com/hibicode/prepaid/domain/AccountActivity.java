package com.hibicode.prepaid.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class AccountActivity {

    private BigDecimal amount;
    private LocalDateTime timestamp;

    public AccountActivity(BigDecimal amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
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
        AccountActivity that = (AccountActivity) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, timestamp);
    }
}
