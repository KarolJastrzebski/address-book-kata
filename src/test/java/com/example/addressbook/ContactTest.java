package com.example.addressbook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactTest {

    @Test
    public void can_tell_how_many_days_is_older_than_other() {
        Contact bill = new Contact("Bill", "Male", "01/01/99");
        Contact paul = new Contact("Paul", "Male", "01/02/99");
        assertThat(bill.daysDifferenceTo(paul)).isEqualTo(31);
    }
}
