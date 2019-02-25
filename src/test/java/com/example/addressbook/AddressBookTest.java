package com.example.addressbook;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookTest {

    @Test
    public void initially_empty() {
        AddressBook addressBook = new AddressBook();
        assertThat(addressBook.getContacts()).hasSize(0);
    }

    @Test
    public void reads_contact() {
        String input = "Bill McKnight, Male, 16/03/77";
        AddressBook addressBook = new AddressBook(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        assertThat(addressBook.getContacts()).hasSize(1)
            .first()
            .hasFieldOrPropertyWithValue("name", "Bill McKnight")
            .hasFieldOrPropertyWithValue("gender", "Male")
            .hasFieldOrPropertyWithValue("dob", "16/03/77");
    }
}
