package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBookImpl = new AddressBookImpl();
    private static final String DESTINATION_FOLDER = "/home/admin1/IdeaProjects/AddressBook/JSONFiles/";

    @Test
    public void checkGivenFile_IfNotPresent_ThenReturnFalse() throws IOException {
        Assert.assertFalse(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book.json"));
    }

    @Test
    public void checkGivenFile_IfPresent_ThenReturnTrue() {
        try {
            Assert.assertTrue(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book1.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToCreateNewFile() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        try {
            Assert.assertEquals("True", addressBookImpl.createNewFile(DESTINATION_FOLDER, "book2.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void toCheckValuesAssignedToPojoOrNot() throws IOException {
        Person person = new Person("mahendra", "kundare", "8149288245",
                "aurangabad", "maharashtra", "431001");
        String result = person.getFirstName();
        Assert.assertEquals("mahendra", result);
    }

    @Test
    public void GivenData_IfStoreinJson_ShouldReturnTrue() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        Assert.assertTrue(addressBookImpl.addPerson("mahendra", "kundare", "8149288245", "aurangabad", "maharashtra", "431001"));
    }


}


