package com.example.contacts;

public class Contacts {
    String nameOfContact;
    String phoneOfContact;
    String firstCharacter_nameOfContact;


    public Contacts(String nameOfContact, String phoneOfContact, String firstCharacter_nameOfContact) {
        this.nameOfContact = nameOfContact;
        this.phoneOfContact = phoneOfContact;
        this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }

    public String getNameOfContact() {
        return nameOfContact;
    }

    public void setNameOfContact(String nameOfContact) {
        this.nameOfContact = nameOfContact;
    }

    public String getPhoneOfContact() {
        return phoneOfContact;
    }

    public void setPhoneOfContact(String phoneOfContact) {
        this.phoneOfContact = phoneOfContact;
    }

    public String getFirstCharacter_nameOfContact() {
        return firstCharacter_nameOfContact;
    }

    public void setFirstCharacter_nameOfContact(String firstCharacter_nameOfContact) {
        this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }
}
