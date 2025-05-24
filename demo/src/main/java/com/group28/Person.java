package com.group28;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    private String birthdate;
    private boolean isSuspended;
    private Date date;

    private HashMap<String, Integer> demeritPoints; // A variable that holds the demerit points with the offense date
    private ArrayList<String> demeritDate = new ArrayList<String>();
    private ArrayList<Integer> demeritValue = new ArrayList<Integer>();

    //Empty Constructor
    public Person(){
        this.personID = "";
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.birthdate = "";
        this.isSuspended = false;
        //initialise date and demerit points?
    }

    //Constructor that can be used for testing
    public Person(String personID, String firstName, String lastName, String address, String birthdate, boolean isSuspended){
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthdate = birthdate;
        this.isSuspended = isSuspended;
        //initialise date and demerit points?
    }

    public void addOffense(String date, int points) {
        this.demeritDate.add(date);
        this.demeritValue.add(points);
    }   

    public String getBirthDate(){
        return this.birthdate;
    }
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getPersonID() {
        return this.personID;
    }

    public String getAddress(){
        return this.address;
    }

    public boolean getSuspensionStatus(){
        return this.isSuspended;
    }
  
    //TODO: This method adds information about a person to a TXT file.
    public boolean addPerson() {
        String pID = this.getPersonID();
        int numSpecialCharacters = 0;
        //Condition 1: PersonID should be exactly 10 characters long;
            if (pID.length() != 10) {
                return false;
            }
            System.out.println("PASSED: LENGTH");
            //The first two characters should be numbers between 2 and 9 *** ASK IF INCLUDED
            for (int i = 0; i < 2; ++i){
                char c = pID.charAt(i);
                if ((!Character.isDigit(c)) || (c < '2') || (c > '9')){
                    return false;
                }
            }
            System.out.println("PASSED: FIRST 2 CHARACTERS");
            //There should be at least two special characters between characters 3 and 8
            for (int i = 2; i < 8; ++i){
                char c = personID.charAt(i);
                if (!Character.isLetterOrDigit(c)){
                    numSpecialCharacters += 1;
                }
            }
            if (numSpecialCharacters < 2){
                return false;
            }
            System.out.println("PASSED: SPECIAL CHARACTERS");
            //The last two characters should be upper case letters (A - Z). 
            for (int i = pID.length() - 1; i >= pID.length(); --i){
                if(Character.isLowerCase(pID.charAt(i))){
                    return false;
                }
            }
            System.out.println("PASSED: LAST 2 CHARACTERS");
        //Example: "56s_q0k6fAB"
        //Condition 2: 
            //The address of the Person should follow the following format: StreetNumber|Street|City|State|Country| (Could implmement more checks).
            String addrs = this.getAddress();
            String[] adParts = addrs.split("\\|");
            if(adParts.length != 5){
                return false;
            }
            //The State should be only Victoria.
            if(!adParts[3].equals("Victoria") || (!adParts[4].equals("Australia"))){
                return false;
            }
            //Example: 32|Highland Street|Melbourne|Victoria|Australia.



        //Condition 3: 
            //The format of the birth date of the person should follow the following format: DD-MM-YYYY. 
            String DOB = this.getBirthDate();
            String[] bdParts = DOB.split("-");
            if(bdParts.length != 3){
                return false;
            }
            
            //checks if month is valid
            if((Integer.parseInt(bdParts[1]) > 12) ||(Integer.parseInt(bdParts[1]) < 1)){
                return false;
            }
            //Example: 15-11-1990
        
        //Instruction: If the Person's information meets the above conditions and any other conditions you may want to consider,
        //the information should be inserted into a TXT file, and the addPerson function should return true.
        //Otherwise, the information should not be inserted into the TXT file, and the addPerson function should return false.
            String output = this.getPersonID() + "\n" + 
                            this.getName() + "\n" + 
                            this.getAddress() + "\n" + 
                            this.getBirthDate() + "\n" +
                            "Suspended: " + this.getSuspensionStatus() + "\n" + "\n";

            Main.writeFile("peopleList", output);

        return true;
    }

    public boolean updatePersonalDetails() {
        //TODO: This method allows updating a given person's ID, firstName, lastName, address and birthday in a TXT file.
        //Changing personal details will not affect their demerit points or the suspension status.
        // All relevant conditions discussed for the addPerson function also need to be considered and checked in the updatePerson function.
        //Condition 1: If a person is under 18, their address cannot be changed.
        //Condition 2: If a person's birthday is going to be changed, then no other personal detail (i.e., person's ID, firstName, lastName, address) can be changed.
        //Condition 3: If the first character/digit of a person's ID is an even number, then their ID cannot be changed.
        //Instruction: If the Person's updated information meets the above conditions and any other conditions you may want to consider,
        //the Person's information should be updated in the TXT file with the updated information, and the updatePersonalDetails function should return true.
        //Otherwise, the Person's updated information should not be updated in the TXT file, and the updatePersonalDetails function should return false.
        return true;
    }

    public String addDemeritPoints(String filename) {
        //To run code do cd to java folder. For Will only. my version outdated or something.
        //javac com/group28/*.java
        //java com.group28.Main

        String status = "Failed"; //Treat as a boolean
        if (this.demeritDate.size() != this.demeritValue.size()) {
            System.out.println("There must be the same number of Dates and Points");
            status = "Failed";
            return status;
        } 

        //TODO: This method adds demerit points for a given person in a TXT file.
        //Condition 1: The format of the date of the offense should follow the following format: DD-MM-YYYY. Example: 15-11-1990
        if (this.demeritDate.size() > 0)
            
            for (int i = 0; i < demeritDate.size(); i++) {
                
                String[] dateParts = demeritDate.get(i).split("-");
                if(dateParts.length == 3){
                    //Maybe i can add more restrictions here
                    if (Integer.parseInt(dateParts[0]) > 31 && Integer.parseInt(dateParts[0]) < 0 && dateParts[0].length() != 2) {
                        System.out.println("Error with DD at record " + i+1 + " .");
                        status = "Failed";
                        return status;
                    }
                    if (Integer.parseInt(dateParts[1]) > 12 && Integer.parseInt(dateParts[1]) < 0 && dateParts[1].length() != 2) {
                        System.out.println("Error with DD at record " + i+1 + " .");
                        status = "Failed";
                        return status;
                    }
                    if (dateParts[2].length() != 4) {
                        System.out.println("Error with YYYY at record " + i+1 + " .");
                        status = "Failed";
                        return status;
                    }   
                }
            }
            else {
                System.out.println("No offenses listed");
            }

        //Condition 2: The demerit points must be a whole number between 1-6
        if (this.demeritValue.size() > 0) {
            for (int i = 0; i < demeritValue.size(); ++i) {
                if (demeritValue.get(i) < 0 && demeritValue.get(i) > 6) {
                    System.out.println("Demerit Points must be between 1-6");
                    status = "Failed";
                    return status;
                }
            }
        }

        //Condition 3: If the person is under 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 6.
        String DOB = this.getBirthDate();
        String[] bdParts = DOB.split("-");
        int totalPoints = 0;

        if (2025 - Integer.parseInt(bdParts[2]) < 21 && 2025 - Integer.parseInt(bdParts[2]) > 0){
            for (int i = 0; i < this.demeritValue.size(); ++i) {
                if (this.demeritDate.get(i).contains("2023") || this.demeritDate.get(i).contains("2024") || this.demeritDate.get(i).contains("2025")) {
                    totalPoints += demeritValue.get(i);
                }
            }
            if (totalPoints > 6) {
                this.isSuspended = true;
            }
        }
        //If the person is over 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 12.
        else if (2025 - Integer.parseInt(bdParts[2]) > 0) {
            for (int i = 0; i < this.demeritValue.size(); ++i) {
                if (this.demeritDate.get(i).contains("2023") || this.demeritDate.get(i).contains("2024") || this.demeritDate.get(i).contains("2025")) {
                    totalPoints += demeritValue.get(i);
                }
            }
            if (totalPoints > 12) {
                this.isSuspended = true;
            }
        }
        else {
            System.out.println("Age must be positive");
            status = "Failed";
            return status;
        }

        //Instruction: If the above conditions and any other conditions you may want to consider are met, the demerit points for a person should be inserted into the TXT file,
        //and the addDemeritPoints function should return "Success". Otherwise, the addDemeritPoints function should return "Failed".
        //I could probably migrate this code somewhere.
        //File creator
        try {
            File myObj = new File(filename + ".txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + filename);
            } 
            else {
                System.out.println("File already exists."); 
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred. When creating the file");
            status = "Failed";
            return status;
        }

        //File writer
        try {
            FileWriter myWriter = new FileWriter(filename + ".txt", true);
            if (this.demeritValue.size() > 0 && this.demeritDate.size() > 0) {
                myWriter.write("Demerit list\n");
                myWriter.write("Date\t\tPoints\n");
                for (int i = 0; i < demeritValue.size(); ++i) {
                    myWriter.write(demeritDate.get(i) + "\t" + demeritValue.get(i) + "\n");
                }
            }
            else {
                myWriter.write("No records found.");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }    
        catch (IOException e) {
            System.out.println("An error occurred. When writing to the file");
            status = "Failed";
            return status;
        }

        status = "Success";
        return status;
    }
}

