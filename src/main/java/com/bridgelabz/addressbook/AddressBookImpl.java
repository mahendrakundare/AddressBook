package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookImpl implements AddressBook {

    @Override
    public void add() {

    }

    public String isFileAvailable(String destinationFolder, String fileName) throws IOException {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            return "True";
        } else {
            return "False";
        }
    }
}