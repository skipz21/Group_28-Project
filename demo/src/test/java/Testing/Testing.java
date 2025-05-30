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
        Person taylorTEST = new Person("56a_b@c!DE", "Taylor", "Swift", "10|Melbourne St|Melbourne|Victoria|Australia", "13-12-1990", false);
        boolean result = taylorTEST.updatePersonalDetails("56a_b@c!DE", "Tayla", "Swiftie", "10|Melbourne St|Melbourne|Victoria|Australia", "13-12-1990");
        
        assertEquals(true, result); // All fields valid, only first/last names changed
    }


    //Test if program will allow under 18's to change their address.
    @Test
    public void underageAddressChangeShouldFail() {
        Person johnTEST = new Person("72@!PorK", "John", "Pork", "22|Calling St|Geelong|Victoria|Australia", "11-01-2010", false);
        boolean result = johnTEST.updatePersonalDetails("72@!PorK", "John", "Pork", "99|Approaching St|Geelong|Victoria|Australia", "11-01-2010");
        
        assertEquals(false, result); // Minor can't change address
    }
    

    //Test if program will allow changing ID when first digit is even
    @Test
    public void cannotChangeEvenStartingID() {
        Person shrekTest = new Person("62s_d@x!PQ", "Shrek", "Ogre", "7|Swamp court|Ballarat|Victoria|Australia", "12-06-1981", false);
        boolean result = shrekTest.updatePersonalDetails("77s_d@x!PQ", "Shrek", "Ogre", "7|Swamp court|Ballarat|Victoria|Australia", "12-06-1981");
        
        assertEquals(false, result); // Can't change ID that starts with even digit
    }


}


