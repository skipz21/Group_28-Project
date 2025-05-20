package com.group28;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Person will = new Person();
        Person thomas = new Person();
        Person balkaran = new Person();
        Person vien = new Person();

        createFile("will");
        writeFile("will");
    }

    //TODO store this txt file in a designated folder. eg testing folder.
    //Edit this logic for all people. iterate through people or list of people as input.
    public static void createFile(String name) {
        try {
            File myObj = new File(name + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } 
            else {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String name) { 
        try {
            FileWriter myWriter = new FileWriter(name + ".txt");
            //Use the person obj and get info and write to file.
            myWriter.write(name);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }    
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}