package com.group28;
import java.util.Date;
import java.util.HashMap;

public class Person {
    private String personID;
    private String firstName;
    private String lastName;
    private String address;
    private String birthdate;
    private HashMap<String, Integer> demeritPoints; // A variable that holds the demerit points with the offense date
    private boolean isSuspended;
    private Date date;

    public Person(){
        this.personID = "";
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.birthdate = "";
        this.isSuspended = false;
        //initialise date and demerit points?
    }

    public String getBirthDate(){
        return this.birthdate;
    }
    public String getName() {
        return this.firstName;
    }

    public String getPersonID() {
        return this.personID;
    }

    public String getAddress(){
        return this.address;
    }
  
    //TODO: This method adds information about a person to a TXT file.
    public boolean addPerson(Person person) {
        String pID = this.getPersonID();
        int numSpecialCharacters = 0;
        //Condition 1: PersonID should be exactly 10 characters long;
            if (pID.length() != 10) {
                return false;
            }
            //The first two characters should be numbers between 2 and 9
            for (int i = 0; i < 2; ++i){
                char c = pID.charAt(i);
                if (!Character.isDigit(c) || c > '2' || c < '9'){
                    return false;
                }
            }
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
            //The last two characters should be upper case letters (A - Z). 
            for (int i = pID.length() - 2; i >= pID.length(); --i){
                if(Character.isLowerCase(pID.charAt(i))){
                    return false;
                }
            }

        //Example: "56s_q0k6fAB"
        //Condition 2: 
            //The address of the Person should follow the following format: StreetNumber|Street|City|State|Country| (Could implmement more checks).
            String addrs = this.getAddress();
            String[] adParts = addrs.split("\\|");
            if(adParts.length != 5){
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
            
            
            
            //Example: 15-11-1990
        
        


        //The State should be only Victoria. Example: 32Highland Street[HeUbourne[Victoria]Australia.
        //Condition 3: The format of the birth date of the person should follow the following format: DD-MM-YYYY. Example: 15-11-1990
        //Instruction: If the Person's information meets the above conditions and any other conditions you may want to consider,
        //the information should be inserted into a TXT file, and the addPerson function should return true.
        //Otherwise, the information should not be inserted into the TXT file, and the addPerson function should return false.
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

    public String addDemeritPoints() {
        //TODO: This method adds demerit points for a given person in a TXT file.
        //Condition 1: The format of the date of the offense should follow the following format: DD-MM-YYYY. Example: 15-11-1990
        //Condition 2: The demerit points must be a whole number between 1-6
        //Condition 3: If the person is under 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 6.
        //If the person is over 21, the isSuspended variable should be set to true if the total demerit points within two years exceed 12.
        //Instruction: If the above conditions and any other conditions you may want to consider are met, the demerit points for a person should be inserted into the TXT file,
        //and the addDemeritPoints function should return "Success". Otherwise, the addDemeritPoints function should return "Failed".
        return "Success";
    }
}

