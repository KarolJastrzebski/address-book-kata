package com.example.addressbook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Contact {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    private final String name;
    private final String gender;
    private final String dob;

    public Contact(String name, String gender, String dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public boolean isGenderOf(String selectedGender) {
        return gender.contentEquals(selectedGender);
    }

    public Date getDateOfBirth() throws ParseException {
        return sdf.parse(dob);
    }

    public int compareDateOfBirth(Contact other) {
        try {
            return getDateOfBirth().compareTo(other.getDateOfBirth());
        } catch (ParseException e) {
            return 0;
        }
    }

    public boolean hasFirstName(String firstName) {
        return name.startsWith(firstName + " ");
    }

    public String getName() {
        return name;
    }

    public long daysDifferenceTo(Contact other) {
        try {
            return ChronoUnit.DAYS.between(getDateOfBirth().toInstant(), other.getDateOfBirth().toInstant());
        } catch (ParseException e) {
            return 0;
        }
    }
}
