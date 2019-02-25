package com.example.addressbook;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public AddressBook() {
    }

    public AddressBook(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        contacts = bufferedReader.lines().map(line -> {
            String[] strings = line.split(", *");
            return new Contact(strings[0], strings[1], strings[2]);
        }).collect(Collectors.toList());
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
