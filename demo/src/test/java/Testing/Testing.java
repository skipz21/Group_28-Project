package Testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.group28.Person;

public class Testing{
//Tests for addPerson function

    //Test if program will write write a person to the text file if their PersonID is invalid length (not 10)
    @Test
    public void invalidPersonID(){
            Person thomas = new Person("35s8_d%^fLX", "Thomas", "Felsenthal", "17|Lit Street|Yodieland|Victoria|Australia", "04-03-2004", false);
            assertEquals(thomas.addPerson(), false);
    }

    //Test if program will write write a person to the text file if their PersonID is valid and follows all requirements
    @Test
    public void validPersonID(){
            Person thomas = new Person("56s_d%&fAB", "Thomas", "Felsenthal", "17|Lit Street|Yodieland|Victoria|Australia", "04-03-2004", false);
            assertEquals(thomas.addPerson(), true);
    }

    //Test if program will write write a person to the text file if their address is not within Victoria
    @Test
    public void validateAddress(){
        Person thomas = new Person("566s_d%&fAB", "Thomas", "Felsenthal", "13|Geek Street|Hobart|Tasmania|Australia", "04-03-2004", false);
        assertEquals(thomas.addPerson(), false);
    }


    //Test if program will write write a person to the text file if their birthdate is invalid (e.g. month == 13)
    @Test
    public void validateBirthdate(){
        Person thomas = new Person("66s_d%&fAB", "Thomas", "Felsenthal", "17|Lit Street|Yodieland|Victoria|Australia", "14-13-2011", false);
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

}


