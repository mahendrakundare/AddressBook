package com.bridgelabz.addressbook;

import java.io.IOException;

public interface AddressBook {
     boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode, String fullPath) throws IOException;

     boolean isFileAvailable(String destinationFolder, String s) throws IOException;

     String readData(String firstName, String fullPath);

     String deleteData(String firstName, String fullPath);

     String deleteFile(String fullPath);

     String editDetails(String lastName, String contactNo, String city, String state, String zipcode, String fullPath);
}
