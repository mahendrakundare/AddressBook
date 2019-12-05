package com.bridgelabz.addressbook;

import java.io.IOException;

public interface AddressBook {
     boolean addPerson(String firstName, String lastName, String contactNo, String city, String state, String zipcode) throws IOException;

     boolean isFileAvailable(String destinationFolder, String fileName) throws IOException;
}
