package com.bridgelabz.addressbook;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
    public boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode) {
        Person person = new Person(firstName, lastName, contactNo, city, state, zipcode);
        personList.add(person);
        System.out.println(person.toString());
        try {
            File file = new File(DESTINATION_FOLDER);
            mapper.writeValue(file, personList);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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