package com.example.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        AddressBook addressBook = new AddressBook(new FileReader(new File("AddressBook")));

        int numberOfMales = addressBook.findByGender("Male").size();
        System.out.println("Number of males in the address book: " + numberOfMales);

        Contact oldest = addressBook.findOldest();
        System.out.println("Oldest person is " + oldest.getName());

        Contact bill = addressBook.findByFirstName("Bill").iterator().next();
        Contact paul = addressBook.findByFirstName("Paul").iterator().next();
        System.out.println(
            String.format(
                "%s is older than %s by %d days",
                bill.getName(),
                paul.getName(),
                bill.daysDifferenceTo(paul)
            )
        );
    }
}
