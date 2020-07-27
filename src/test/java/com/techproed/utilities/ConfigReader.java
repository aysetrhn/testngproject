package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //The purpose of this class is to read tha data in the configuration.properties file
    //Bu classin amacı configuration.properties dosyasındaki verileri(data) okumaktır
    //Creating a Properties instance
    private static Properties properties;
    //WE ARE OPENNING A FILE, USING FILE INPUT STREAM
    //WE ARE LOADING THE PROPERTIES IN THAT FILE
    //THEN WE READ properties FILE
    //creating static block to initialize
    static {
        String path = "configuration.properties";
        try{
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        }catch (Exception e){
            //System.out.println("Path is not found");
            e.printStackTrace();
        }
    }
    //We are create static method to read
    //This method will return the value, when user enter the key
    public static String getProperty(String key){

        return properties.getProperty(key);
    }

}
