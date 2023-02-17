package com.ddd.bootcamp.bank.domain;

public class Account {

  private  Address address;

  public Account(Address address) {
    this.address = address;
  }

  protected void updateAddress(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }
}
