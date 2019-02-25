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

    @Test
    public void reads_multiple_contacts() {
        String input = "Bill McKnight, Male, 16/03/77\n"
            + "Gemma Lane, Female, 20/11/91";

        AddressBook addressBook = new AddressBook(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        assertThat(addressBook.getContacts()).hasSize(2)
            .last()
            .hasFieldOrPropertyWithValue("name", "Gemma Lane")
            .hasFieldOrPropertyWithValue("gender", "Female")
            .hasFieldOrPropertyWithValue("dob", "20/11/91");
    }

    @Test
    public void finds_contacts_by_gender() {
        String input = "Bill McKnight, Male, 16/03/77\n"
            + "Gemma Lane, Female, 20/11/91";

        AddressBook addressBook = new AddressBook(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        assertThat(addressBook.findByGender("Female")).hasSize(1)
            .first()
            .hasFieldOrPropertyWithValue("name", "Gemma Lane")
            .hasFieldOrPropertyWithValue("gender", "Female")
            .hasFieldOrPropertyWithValue("dob", "20/11/91");
    }

    @Test
    public void finds_oldest_contact() {
        String input = "Bill McKnight, Male, 16/03/77\n"
            + "Wes Jackson, Male, 14/08/74\n"
            + "Gemma Lane, Female, 20/11/91";

        AddressBook addressBook = new AddressBook(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        assertThat(addressBook.findOldest())
            .hasFieldOrPropertyWithValue("name", "Wes Jackson")
            .hasFieldOrPropertyWithValue("gender", "Male")
            .hasFieldOrPropertyWithValue("dob", "14/08/74");
    }

    @Test
    public void find_contact_by_first_name() {
        String input = "Bill McKnight, Male, 16/03/77\n"
            + "Wes Jackson, Male, 14/08/74\n"
            + "Gemma Lane, Female, 20/11/91";

        AddressBook addressBook = new AddressBook(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        assertThat(addressBook.findByFirstName("Gemma")).hasSize(1)
            .first()
            .hasFieldOrPropertyWithValue("name", "Gemma Lane")
            .hasFieldOrPropertyWithValue("gender", "Female")
            .hasFieldOrPropertyWithValue("dob", "20/11/91");
    }
}
