package com.bridgelabz.addressbook;

public class Person {
    private String firstName;
    private String lastName;
    private String contactNo;
    private String city;
    private String state;
    private String zipCode;

    public Person(String firstName, String lastName, String contactNo, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString()
    {
        return "firstName "+getFirstName()+" lastName "+getLastName()+" contactNo "+getContactNo()+" city "
                +getCity()+" state "+getState() +" zipcode "+getZipCode();
    }

}
