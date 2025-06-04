package Testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.group28.Main;
import com.group28.Person;

public class Testing{
//--------------------- Tests for addPerson() ---------------------

    //Test if the function will return false if the input PersonID has an invalid length (not 10).
    @Test
    public void invalidPersonIDLength(){
            Person thomas = new Person("35s8_d%^fLX", "Thomas", "Felsenthal", "17|Lit Street|Yodieland|Victoria|Australia", "04-03-2004", false);
            assertEquals(thomas.addPerson(), false);
    }

    //Test if the function will return false if the input PersonID has invalid first 2 characters (should be numbers between 2 and 9).
    @Test
    public void invalidPersonIDCharacters(){
        Person thomas = new Person("11s_d%&fAB", "Michael", "Jackson", "17|Ayden Street|Manchester|Victoria|Australia", "14-13-2011", false);
        assertFalse(thomas.addPerson());
    }

    //Test if the function will return true if the input PersonID is valid and follows all requirements.
    @Test
    public void validPersonID(){
            Person thomas = new Person("56s_d%&fAB", "Andrew", "Markus", "81|Hood Street|Newport|Victoria|Australia", "03-08-2003", false);
            assertEquals(thomas.addPerson(), true);
    }

    //Test if the function will return false if the input address is not within Victoria.
    @Test
    public void validAddress(){
        Person thomas = new Person("566s_d%&fAB", "Luther", "Vandross", "13|Geek Street|Hobart|Tasmania|Australia", "04-03-2004", false);
        assertEquals(thomas.addPerson(), false);
    }


    //Test if the function will return false if the input birthdate is invalid (e.g. month == 13)
    @Test
    public void invalidBirthdate(){
        Person thomas = new Person("66s_d%&fAB", "Michael", "Jackson", "17|Ayden Street|Manchester|Victoria|Australia", "14-13-2011", false);
        assertFalse(thomas.addPerson());
    }
    

//--------------------- Tests for updatePersonalDetails() ---------------------



    //Test if program will update details when all values are valid entries.
    @Test
    public void updateAllValidDetails() {
        Person gatoTEST = new Person("56a_b@c!DE", "El", "Gato", "10|Creature St|Melbourne|Victoria|Australia", "13-12-1990", false);
        boolean result = gatoTEST.updatePersonalDetails("56a_b@c!DE", "La", "Gatito", "10|Creature St|Melbourne|Victoria|Australia", "13-12-1990");
        
        assertEquals(true, result); // All fields valid, only first/last names changed
    }


    //Test if program will deny under 18's to change their address.
    @Test
    public void underageAddressChangeShouldFail() {
        Person johnTEST = new Person("72@!PorK", "John", "Pork", "22|Calling St|Geelong|Victoria|Australia", "11-01-2010", false);
        boolean result = johnTEST.updatePersonalDetails("72@!PorK", "John", "Pork", "99|Approaching St|Geelong|Victoria|Australia", "11-01-2010");
        
        assertEquals(false, result); // Minor can't change address
    }


    //Test if program will deny changing ID when first digit is even
    @Test
    public void cannotChangeEvenStartingID() {
        Person shrekTest = new Person("62s_d@x!PQ", "Shrek", "Ogre", "7|Swamp court|Ballarat|Victoria|Australia", "12-06-1981", false);
        boolean result = shrekTest.updatePersonalDetails("77s_d@x!PQ", "Shrek", "Ogre", "7|Swamp court|Ballarat|Victoria|Australia", "12-06-1981");
        
        assertEquals(false, result); // Can't change ID that starts with even digit
    }


    //Test if program will deny changing DOB and other fields concurrently.
    @Test
    public void birthdateChangeWithOtherFieldsShouldFail() {
        Person lebronTest = new Person("57k_l#r$MN", "Lebron", "James", "25|Sunshine Avenue|Melbourne|Victoria|Australia", "01-09-1996", false);
        boolean result = lebronTest.updatePersonalDetails("57k_l#r$MN", "Lebron", "Goat", "25|Sunshine Avenue|Melbourne|Victoria|Australia", "02-02-1995");
        
        assertEquals(false, result); // Can't change DOB and another field
    }


    //Test if program will allow changing DOB only.
    @Test
    public void validBirthdateChangeOnly() {
        Person ryanTest = new Person("59g_h%v^XY", "Ryan", "Gosling", "30|Me Blvd|Melbourne|Victoria|Australia", "11-10-1979", false);
        boolean result = ryanTest.updatePersonalDetails("59g_h%v^XY", "Ryan", "Gosling", "30|Me Blvd|Melbourne|Victoria|Australia", "12-11-1980");
        
        assertEquals(true, result); // Valid DOB-only change
    }

    //--------------------- Tests for addDemeritPoints() ---------------------
    @Test
    public void pointsOutOfRange() {
        String filename = "test";
        //Must create file because addDemeritPoints writes to that file
        Main.createFile(filename);
        //We would need to create the person first with their birthday to properly determine age.
        Person ovoTEST = new Person("57a_b@c!DE", "len", "ovo", "1|Microsoft St|Melbourne|Victoria|Australia", "13-11-1912", false);

        //Actual data we are testing
        ovoTEST.addOffense("13-10-2024", 7);

        String status = ovoTEST.addDemeritPoints(filename);
        boolean result = false;

        if (status == "Success") {
            result = true;
        }

        assertEquals(false, result); 
    }
    
    @Test
    public void checkSuspension1() {
        String filename = "test1";
        Main.createFile(filename);

        Person osTEST = new Person("58a_b@c!DE", "mac", "os", "1|Apple St|Melbourne|Victoria|Australia", "13-10-2005", false);

        //Actual data we are testing
        osTEST.addOffense("30-06-2023", 3);
        osTEST.addOffense("02-01-2024", 2);
        osTEST.addOffense("01-06-2025", 3);

        String status = osTEST.addDemeritPoints(filename);
        boolean result = false;

        if (status == "Success") {
            result = true;
        }

        assertEquals(true, result); 
    }

    @Test
    public void checkSuspension2() {
        String filename = "test2";
        Main.createFile(filename);
        
        Person eggTEST = new Person("59a_b@c!DE", "easter", "egg", "1|Easter St|Melbourne|Victoria|Australia", "01-01-2000", false);

        //Actual data we are testing
        eggTEST.addOffense("12-05-2023", 3);
        eggTEST.addOffense("17-04-2024", 2);
        eggTEST.addOffense("23-06-2025", 4);

        String status = eggTEST.addDemeritPoints(filename);
        boolean result = false;

        if (status == "Success") {
            result = true;
        }

        assertEquals(true, result);
    }

    @Test
    public void invalidDateFormat() {
        String filename = "test3";
        Main.createFile(filename);
        
        Person jacksonTEST = new Person("60a_b@c!DE", "Michael", "Jackson", "1|SmoothCriminal St|Melbourne|Victoria|Australia", "14-11-1987", false);

        //Actual data we are testing
        jacksonTEST.addOffense("1-06-2021", 1);

        String status = jacksonTEST.addDemeritPoints(filename);
        boolean result = false;

        if (status == "Success") {
            result = true;
        }

        assertEquals(false, result);
    }

    @Test
    public void validDateFormat() {
        String filename = "test4";
        Main.createFile(filename);
        
        Person plutoTEST = new Person("61a_b@c!DE", "Armond", "Pluto", "1|Knight St|Melbourne|Victoria|Australia", "03-06-1991", false);

        //Actual data we are testing
        plutoTEST.addOffense("04-02-2020", 1);

        String status = plutoTEST.addDemeritPoints(filename);
        boolean result = false;

        if (status == "Success") {
            result = true;
        }

        assertEquals(true, result);
    }
}


