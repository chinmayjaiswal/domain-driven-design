package com.ddd.bootcamp.bank.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void shouldUpdateCustomerAddressAndItsBankAccountAddress() {
    Address puneAddress = new Address("Pune");
    Account account = new Account(puneAddress);
    Customer customer = new Customer(puneAddress, List.of(account));

    customer.updateAddress(new Address("Mumbai"));

    Assertions.assertThat(customer.getAddress().getCity()).isEqualTo("Mumbai");
    customer.getBankAccounts().stream().forEach(account1 -> {
      Assertions.assertThat(account1.getAddress().getCity()).isEqualTo("Mumbai");
    });

  }
}