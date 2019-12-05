package com.bridgelabz.addressbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookImpl implements AddressBook {
    private static final String DESTINATION_FOLDER = "/home/admin1/IdeaProjects/AddressBook/JSONFiles/book1.json";

    Person person = new Person();
    List<Person> personList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode, String fullPath) {
        Person person = new Person(firstName, lastName, contactNo, city, state, zipcode);
        personList.add(person);
        System.out.println(person.toString());
        saveToJsonFile(personList,fullPath);
            return true;
    }

    private void saveToJsonFile(List<Person> personList, String fullPath) {
        File file = new File(fullPath);
        try {
            mapper.writeValue(file,personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.createNewFile())
            return "True";
        else
            return "False";
    }

}