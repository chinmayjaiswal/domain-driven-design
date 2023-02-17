package com.ddd.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<CartItem> items = new ArrayList<>();

  public void addItem(CartItem item) {
    items.add(item);
  }

  public boolean hasItem(CartItem item) {
    return items.stream()
        .filter(entry -> entry.getProduct().getName().equals(item.getProduct().getName()))
        .findFirst()
        .orElse(null) != null;
  }

  public CartItem getItem(Product product) throws ItemDoesNotExistsException {
    return items.stream().filter(item -> item.getProduct().equals(product)).findFirst().orElseThrow(
        ItemDoesNotExistsException::new);
  }

  public void remove(CartItem item) throws ItemDoesNotExistsException {
    CartItem itemToRemove = this.getItem(item.getProduct());
    items.remove(itemToRemove);

  }
}
