package com.example.addressbook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookTest {

    @Test
    public void initially_empty() {
        AddressBook addressBook = new AddressBook();
        assertThat(addressBook.getContacts()).hasSize(0);
    }
}
