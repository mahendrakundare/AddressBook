package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookImpl implements AddressBook {

    Person person = new Person();
    List<Person> personList = new ArrayList<>();
    @Override
    public void addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode) {
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setContactNo(contactNo);
        person.setCity(city);
        person.setState(state);
        person.setZipCode(zipcode);
        personList.add(person);
        System.out.println(person.toString());
    }

    public boolean isFileAvailable(String destinationFolder, String fileName) throws IOException {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public String createNewFile(String destinationFolder, String fileName) throws IOException {
        String fullPath = destinationFolder+fileName;
        File file = new File(fullPath);
        if (file.createNewFile())
            return "True";
        else
            return "False";
    }
}