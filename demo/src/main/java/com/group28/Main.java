package com.group28;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        createFile("peopleList");
        Person balkaran = new Person();
        Person vien = new Person();
        
        Person will = new Person("wow", "William", "L", "13|Earth Street|Yololand|Cooked|Neptune", "03-03-2006", false);
        will.addOffense("20-10-2021", 1);
        will.addOffense("20-10-2023", 5);

        String output;
        output = will.addDemeritPoints("testing");
        System.out.println("[" + output + "]");

        Person thomas = new Person("56s_d%&fAB", "Thomas", "Felsenthal", "17|Lit Street|Yodieland|Victoria|Australia", "04-03-2004", false);
        thomas.addPerson();
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

    public static void writeFile(String name, String content) { 
        try {
            FileWriter myWriter = new FileWriter(name + ".txt", true);
            //Use the person obj and get info and write to file.
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }    
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}