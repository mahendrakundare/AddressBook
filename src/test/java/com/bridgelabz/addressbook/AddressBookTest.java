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
    public void checkGivenFile_IfPresent_ThenReturnTrue() throws IOException {
        Assert.assertTrue(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book1.json"));
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
        Assert.assertTrue(addressBookImpl.addPerson("avengers", "kundare", "8149288245", "aurangabad",
                "karnataka", "431001",fullPath));
    }

    //t6
    @Test
    public void CheckDataAvailableOrNot() {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        Assert.assertEquals("FOUND",addressBookImpl.readData("mahendra",fullPath));
    }

    //t7
    @Test
    public void GivenRecord_IfDelete_ShouldReturnTrue() {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        Assert.assertEquals("removed",addressBookImpl.deleteData("avengers",fullPath));
    }

    //t8
    @Test
    public void GivenFile_IfDelete_ShouldReturnTrue() {
        String fullPath=DESTINATION_FOLDER+"book2.json";
        Assert.assertEquals("Deleted",addressBookImpl.deleteFile(fullPath));
    }

    //t9
    @Test
    public void GivenFileForDelete_IfNotPresent_ShouldReturn_False() {
        String fullPath=DESTINATION_FOLDER+"book2.json";
        Assert.assertEquals("notdeleted",addressBookImpl.deleteFile(fullPath));
    }
}


