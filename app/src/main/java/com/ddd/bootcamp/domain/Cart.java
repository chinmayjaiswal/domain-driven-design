package com.ddd.bootcamp.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<CartItem> items = new ArrayList<>();

  private String status = null;

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

  public Order checkout() {
    List<Product> products = new ArrayList<>();
    items.forEach(cartItem -> {
      for(int count = 0;  count < cartItem.getQuantity(); count++ ){
        products.add(cartItem.getProduct());
      }

    });

    Order order = new Order(products);
    this.status = "CHECKED_OUT";
    return order;
  }

  public String getStatus() {
    return status;
  }
}
