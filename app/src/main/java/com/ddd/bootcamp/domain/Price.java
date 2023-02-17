package com.ddd.bootcamp.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {

  private final BigDecimal amount;

  private final Currency currency;
  public Price(BigDecimal amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Price{" +
        "amount=" + amount +
        ", currency=" + currency +
        '}';
  }
}
