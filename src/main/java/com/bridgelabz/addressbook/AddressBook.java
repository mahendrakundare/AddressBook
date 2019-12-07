package com.bridgelabz.addressbook;

import java.io.IOException;

public interface AddressBook {
     boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode, String fullPath) throws AddressBookException;

     boolean isFileAvailable(String destinationFolder, String s) throws IOException;

     String readData(String firstName, String fullPath);

     String deleteData(String contactNo, String fullPath);

     String deleteFile(String fullPath);

     String editDetails(String lastName, String contactNo, String city, String state, String zipcode, String fullPath);

     String sortByName(String fullPath);

     String sortByZip(String fullPath);
}
