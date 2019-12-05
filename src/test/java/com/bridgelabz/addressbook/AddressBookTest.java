package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBookImpl = new AddressBookImpl();
    private static final String DESTINATION_FOLDER = "/home/admin1/IdeaProjects/AddressBook/JSONFiles/";

    //t1
    @Test
    public void checkGivenFile_IfNotPresent_ThenReturnFalse() throws IOException {
        Assert.assertFalse(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book.json"));
    }

    //t2
    @Test
    public void checkGivenFile_IfPresent_ThenReturnTrue() {
        try {
            Assert.assertTrue(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book1.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //t3
    @Test
    public void testToCreateNewFile() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        try {
            Assert.assertEquals("True", addressBookImpl.createNewFile(DESTINATION_FOLDER, "book2.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //t4
    @Test
    public void toCheckValuesAssignedToPojoOrNot() throws IOException {
        Person person = new Person("mahendra", "kundare", "8149288245",
                "aurangabad", "maharashtra", "431001");
        String result = person.getFirstName();
        Assert.assertEquals("mahendra", result);
    }

    //t5
    @Test
    public void GivenData_IfStoreinJson_ShouldReturnTrue() throws IOException {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        Assert.assertTrue(addressBookImpl.addPerson("mahendra", "kundare", "8149288245", "aurangabad",
                "karnataka", "431001",fullPath));
    }

}


