package com.ddd.bootcamp.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class DiscountService {
  public Map<String, Price> competitorPriceMap = new HashMap<>() {
    {
      put("Apple Pencil", new Price(BigDecimal.TEN, Currency.getInstance("USD")));

      put("Sony Wireless Headphone", new Price(BigDecimal.valueOf(10L), Currency.getInstance("USD")));
    }
  };

  public BigDecimal getDiscountedAmount(String productName, BigDecimal defaultPrice) {
    if(competitorPriceMap.containsKey(productName)) {
      return competitorPriceMap.get(productName).getAmount().multiply(BigDecimal.valueOf(0.90));
    }else {
      return defaultPrice;
    }
  }
}
