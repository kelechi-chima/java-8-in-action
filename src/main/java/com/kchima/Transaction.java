package com.kchima;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {

    final Currency currency;
    final BigDecimal amount;
    
    public Transaction(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Transaction(currency=%s, amount=%s)", currency, amount);
    }
}
