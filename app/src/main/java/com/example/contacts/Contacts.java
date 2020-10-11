package com.example.contacts;

public class Contacts {
    String name;
    String phone;
    String firstCharacterOfName;

    Contacts(){

    }

    public Contacts(String name, String phone ,String firstCharacterOfName) {
        this.name = name;
        this.phone = phone;
        this.firstCharacterOfName = firstCharacterOfName;
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


    public String getFirstCharacterOfName() {
        return firstCharacterOfName;
    }

    public void setFirstCharacterOfName(String firstCharacterOfName) {
        this.firstCharacterOfName = firstCharacterOfName;
    }
}
