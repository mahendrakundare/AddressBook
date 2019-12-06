package com.bridgelabz.addressbook;

public class AddressBookException extends Exception {
    enum ExceptionType {
        FILE_NOT_FOUND
    }

    ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
