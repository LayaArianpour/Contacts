package com.example.contacts;

public class Contacts {
    String name;
    String phone;
  //  String firstCharacter_nameOfContact;

    Contacts(){

    }

    public Contacts(String nameOfContact, String phoneOfContact, String firstCharacter_nameOfContact) {
        this.name = nameOfContact;
        this.phone = phoneOfContact;
       // this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }

    public String getNameOfContact() {
        return name;
    }

    public void setNameOfContact(String nameOfContact) {
        this.name = nameOfContact;
    }

    public String getPhoneOfContact() {
        return phone;
    }

    public void setPhoneOfContact(String phoneOfContact) {
        this.phone = phoneOfContact;
    }

   /* public String getFirstCharacter_nameOfContact() {
        return firstCharacter_nameOfContact;
    }

    public void setFirstCharacter_nameOfContact(String firstCharacter_nameOfContact) {
        this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }*/
}
