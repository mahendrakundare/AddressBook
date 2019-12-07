package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    AddressBook addressBookImpl = new AddressBookImpl();
    private static final String DESTINATION_FOLDER = "/home/admin1/IdeaProjects/AddressBook/JSONFiles/";

    //t1
    @Test
    public void checkGivenFile_IfNotPresent_ThenReturnFalse()  {
        try {
            Assert.assertFalse(addressBookImpl.isFileAvailable(DESTINATION_FOLDER, "book.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //t2
    @Test
    public void checkGivenFile_IfPresent_ThenReturnTrue()  {
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
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    //t13
    @Test
    public void testFileGivenNameIfBlankShouldReturnFalse() {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
        try {
            Assert.assertEquals("False",addressBookImpl.createNewFile(DESTINATION_FOLDER,""));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    //t14
    @Test
    public void GivenFileName_IfNull_ShouldThrowError() throws AddressBookException {
        AddressBookImpl addressBookImpl = new AddressBookImpl();
            Assert.assertEquals("False",addressBookImpl.createNewFile(DESTINATION_FOLDER,null));
    }

    //t4
    @Test
    public void toCheckValuesAssignedToPojoOrNot()  {
        Person person = new Person("mahendra", "kundare", "8149288245",
                "aurangabad", "maharashtra", "431001");
        String result = person.getFirstName();
        Assert.assertEquals("mahendra", result);
    }

    //t5
    @Test
    public void GivenData_IfStoreinJson_ShouldReturnTrue() throws AddressBookException {
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
//        addressBookImpl.deleteData("avengers",fullPath);
        Assert.assertEquals("removed",addressBookImpl.deleteData("1234567890",fullPath));
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


    //t10
    @Test
    public void toTestGivenRecordShouldEdit_ShouldReturnTrue() {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        Assert.assertEquals("Edited",addressBookImpl.editDetails( "kundare", "1234567890",
                "pune", "karnataka", "147852",fullPath));
    }

    //t11
    @Test
    public void toTestWhenSortByName_ShouldReturnAlphabeticallyTopElement() {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        String topElement=addressBookImpl.sortByName(fullPath);
        Assert.assertEquals("abc",topElement);
    }

    //t12
    @Test
    public void toTestWhenSortByName_ShouldReturnAlphabeticallyTopZipCode() {
        String fullPath=DESTINATION_FOLDER+"book1.json";
        String topElement=addressBookImpl.sortByZip(fullPath);
        Assert.assertEquals("100000",topElement);
    }
}


