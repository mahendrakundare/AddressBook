package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    private static final String DESTINATION_FOLDER ="/home/admin1/IdeaProjects/AddressBook/JSONFiles/";

    @Test
    public void checkGivenFile_IfNotPresent_ThenReturnFalse() throws IOException {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        Assert.assertFalse(addressBookImpl.isFileAvailable(DESTINATION_FOLDER,"book.json"));
    }

    @Test
    public void checkGivenFile_IfPresent_ThenReturnTrue() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        try {
            Assert.assertTrue(addressBookImpl.isFileAvailable(DESTINATION_FOLDER,"book1.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToCreateNewFile() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        try {
            Assert.assertEquals("True",addressBookImpl.createNewFile(DESTINATION_FOLDER,"book2.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void toCheckValuesAssignedToPojoOrNot() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        Person person = new Person("mahendra","kundare","8149288245",
                "aurangabad","maharashtra","431001");
        String result = person.getFirstName();
        Assert.assertEquals("mahendra",result);
    }
}


