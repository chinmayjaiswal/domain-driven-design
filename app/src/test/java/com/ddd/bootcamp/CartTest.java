package com.ddd.bootcamp;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CartTest {

  @Test
  void shouldAddApplePencilToCart() {
    Cart cart = new Cart();

    Product applePencil = new Product("Apple Pencil");
    CartItem applePencilItem = new CartItem(applePencil, 1);
    cart.addItem(applePencilItem);

    Assertions.assertThat(cart.hasItem(applePencilItem)).isTrue();

  }

  @Test
  void shouldAddSonyWirelessHeadphoneToCart() {
    Cart cart = new Cart();

    Product headphones = new Product("Sony Wireless headphone");
    CartItem headPhoneItem = new CartItem(headphones, 1);
    cart.addItem(headPhoneItem);

    Assertions.assertThat(cart.hasItem(headPhoneItem)).isTrue();

  }

  @Test
  void shouldAddTwoQuantitiesOfApplePencil() throws ItemDoesNotExistsException {
    Cart cart = new Cart();

    Product applePencil = new Product("Apple Pencil");
    CartItem applePencilItem = new CartItem(applePencil, 2);
    cart.addItem(applePencilItem);

    Assertions.assertThat(cart.hasItem(applePencilItem)).isTrue();
    Assertions.assertThat(cart.getItem(applePencil).getQuantity()).isEqualTo(2);
  }

  @Test
  void shouldAddMultipleItemsToCart() throws ItemDoesNotExistsException {
    Cart cart = new Cart();

    Product headphones = new Product("Sony Wireless headphone");
    CartItem headPhoneItem = new CartItem(headphones, 1);
    cart.addItem(headPhoneItem);

    Product applePencil = new Product("Apple Pencil");
    CartItem applePencilItem = new CartItem(applePencil, 2);
    cart.addItem(applePencilItem);

    Assertions.assertThat(cart.hasItem(headPhoneItem)).isTrue();
    Assertions.assertThat(cart.hasItem(applePencilItem)).isTrue();
    Assertions.assertThat(cart.getItem(applePencil).getQuantity()).isEqualTo(2);
  }

  @Test
  void shouldRemoveItem() throws ItemDoesNotExistsException {
    Cart cart = new Cart();
    Product applePencil = new Product("Apple Pencil");
    CartItem applePencilItem = new CartItem(applePencil, 2);
    cart.addItem(applePencilItem);

    cart.remove(applePencilItem);
    Assertions.assertThat(cart.hasItem(applePencilItem)).isFalse();
  }
}