package com.example.contacts;

public class Contacts {
    String name;
    String phone;
  //  String firstCharacter_nameOfContact;

    Contacts(){

    }

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
       // this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   /* public String getNameOfContact() {
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

    public String getFirstCharacter_nameOfContact() {
        return firstCharacter_nameOfContact;
    }

    public void setFirstCharacter_nameOfContact(String firstCharacter_nameOfContact) {
        this.firstCharacter_nameOfContact = firstCharacter_nameOfContact;
    }*/
}
