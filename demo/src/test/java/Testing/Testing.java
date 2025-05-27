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
}


