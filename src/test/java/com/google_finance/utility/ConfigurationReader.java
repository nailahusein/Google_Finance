package com.google_finance.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Creating the Properties object (create object)
    //making it "private" so I am limiting access to the object
    //"static" is to make sure its created and loaded before everything else.
    private static Properties properties = new Properties();

    static{

        try {
            //2- Opening file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }

    //create a utility method to use the object to read
    //4- Use "properties" object to read from the file (read properties)

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
