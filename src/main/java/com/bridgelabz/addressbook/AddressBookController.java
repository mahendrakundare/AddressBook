package com.bridgelabz.addressbook;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressBookController {

    ObjectMapper mapper = new ObjectMapper();

    public void saveToJsonFile(List<Person> personList, String fullPath) {
        File file = new File(fullPath);
        try {
            mapper.writeValue(file,personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> ReadFromJson(String fullPath) {
        File file = new File(fullPath);
        try {
            List<Person> list = new ArrayList(Arrays.asList(mapper.readValue(file, Person[].class)));
            return list;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createNewFile(String destinationFolder, String fileName){
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        try {
            if (file.createNewFile())
                return "True";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "False";
    }

    public boolean isFileAvailable(String destinationFolder, String fileName) {
        String fullPath = destinationFolder + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

}
