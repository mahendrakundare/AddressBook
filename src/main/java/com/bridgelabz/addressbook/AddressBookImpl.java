package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookImpl implements AddressBook {

    @Override
    public void add() {

    }

    public String isFileAvailable(String destinationFolder, String fileName) throws IOException {
        File file = new File(destinationFolder);
        if (file.createNewFile())
            return "true";
        else
            return "false";
    }
}
