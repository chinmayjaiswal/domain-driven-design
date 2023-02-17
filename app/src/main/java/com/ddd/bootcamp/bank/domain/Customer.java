package com.ddd.bootcamp.bank.domain;

import java.util.List;

public class Customer {

  private final List<Account> bankAccounts;
  private Address address;

  public Customer(Address address, List<Account> bankAccounts) {
    this.address = address;
    this.bankAccounts = bankAccounts;
  }

  public void updateAddress(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }
}
