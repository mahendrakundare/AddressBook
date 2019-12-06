package com.bridgelabz.addressbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookImpl implements AddressBook {
    private static final String DESTINATION_FOLDER = "/home/admin1/IdeaProjects/AddressBook/JSONFiles/book1.json";

    Person person = new Person();
    //    List<Person> personList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    AddressBookController controller = new AddressBookController();

    @Override
    public boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode, String fullPath) {
        Person person = new Person(firstName, lastName, contactNo, city, state, zipcode);
        List<Person> list = controller.ReadFromJson(fullPath);
        list.add(person);
        System.out.println(person.toString());
        controller.saveToJsonFile(list, fullPath);
        return true;
    }

    public String createNewFile(String destinationFolder, String fileName)  {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        try {
            if (file.createNewFile())
                return "True";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "False";
    }

    public boolean isFileAvailable(String destinationFolder, String fileName) {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String readData(String firstName, String fullPath) {
        List<Person> list = controller.ReadFromJson(fullPath);
        for (Person p : list)
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(p.getFirstName());
                return "FOUND";
            }
        return "NOTFOUND";
    }

    @Override
    public String deleteData(String contactNo, String fullPath) {
        List<Person> list = controller.ReadFromJson(fullPath);
        List<Person> locallist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (!contactNo.equalsIgnoreCase(list.get(i).getContactNo())) {
                locallist.add(list.get(i));
                controller.saveToJsonFile(locallist, fullPath);
            } else {
                list.remove(list.get(i));
                controller.saveToJsonFile(list, fullPath);
                return "removed";
            }
        }
        return "not removed";
    }

    @Override
    public String deleteFile(String fullPath) {
        File file = new File(fullPath);
        if (file.delete())
            return "Deleted";
        else
            return "notdeleted";
    }

    @Override
    public String editDetails(String lastName, String contactNo, String city, String state, String zipcode, String fullPath) {
        List<Person> personList = controller.ReadFromJson(fullPath);
        for (int i = 0; i < personList.size(); i++) {
            if (contactNo.equalsIgnoreCase(personList.get(i).getContactNo())) {
                personList.get(i).setLastName(lastName);
                personList.get(i).setCity(city);
                personList.get(i).setState(state);
                personList.get(i).setZipCode(zipcode);
                controller.saveToJsonFile(personList, fullPath);
                return "Edited";
            }
        }
        return "notEdited";
    }

    @Override
    public String sortByName(String fullPath) {
        String topElement = "null";
        List<Person> personList = controller.ReadFromJson(fullPath);
        for (int i = 0; i < personList.size(); i++) {
            for (int j = i + 1; j < personList.size(); j++) {
                if (personList.get(i).getFirstName().compareTo(personList.get(j).getFirstName()) > 0) {
                    Person temp1 = personList.remove(i);
                    Person temp2 = personList.remove(j - 1);
                    personList.add(i, temp2);
                    personList.add(j, temp1);
                }
            }
        }
        return topElement = personList.get(0).getFirstName();
    }

    @Override
    public String sortByZip(String fullPath) {
        String topElement = "null";
        List<Person> personList = controller.ReadFromJson(fullPath);
        for (int i = 0; i < personList.size(); i++) {
            for (int j = i + 1; j < personList.size(); j++) {
                if (personList.get(i).getZipCode().compareTo(personList.get(j).getZipCode()) > 0) {
                    Person temp1 = personList.remove(i);
                    Person temp2 = personList.remove(j - 1);
                    personList.add(i, temp2);
                    personList.add(j, temp1);
                }
            }
        }
        return topElement = personList.get(0).getZipCode();
    }


}