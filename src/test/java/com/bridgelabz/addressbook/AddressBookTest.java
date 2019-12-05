package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    private static final String DESTINATION_FOLDER ="/home/admin1/IdeaProjects/AddressBook/JSONFiles/";

    @Test
    public void checkGivenFile_IfNotPresent_ThenReturnFalse() throws IOException {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        Assert.assertEquals("false",addressBookImpl.isFileAvailable(DESTINATION_FOLDER,"book1.json"));
    }
}
