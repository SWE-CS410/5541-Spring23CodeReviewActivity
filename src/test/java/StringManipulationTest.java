import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The class is test harness to run the test workflow.
 *
 * @author DeWayne Dantzler dewayne.dantler@bellevuecollege.edu
 */
public class StringManipulationTest {

    private StringManipulationInterface manipulatedstring;

    @BeforeEach
    public void setUp() {
        manipulatedstring = new StringManipulation();
    }

    @AfterEach
    public void tearDown() {
        manipulatedstring = null;
    }

    @Test//Test if the count of words matches the expected value
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test//Test if null string returns a count == 0
    public void testCount2() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
    	assertEquals(0, length);
    }

    @Test//Test is the empty string returns a count == 0
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
    	assertEquals(0, length);
    }

    @Test//Test if given a very long string, but only one string that the count == 1
    public void testCount4() {
        manipulatedstring.setString("ThisIsJustOneLongStringWithoutBlanksAsDelimiterSoItShouldBeCountedAsOne");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test//Test removal of chars without inserting blanks returns a smaller string
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test//Test if replacing chars with blanks maintains the original size
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test //assert throws IllegalArgumentException if n == 0
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("123");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(0,true);});
    }

    @Test //assert throws IllegalArgumentException if n < 0
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("123");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(-4,true);});
    }

    @Test //assert throws IndexOutOfBoundsException if n > length of string
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("123");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.removeNthCharacter(1000,true);});
    }

    @Test//Test to see if we can remove all the characters leaving an empty string
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test//Test to see if we can replace all the characters with blanks
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("                                                 ", manipulatedstring.removeNthCharacter(1, true));
                            //"I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?"
    }

    @Test//Test basic substring operation - Happy Path
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test//Assert IllegalArgumentException if "startWord" <= 0
    public void testGeSubStrings2() {
        manipulatedstring.setString("Throw me to the wolves and I will come back leading the pack");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(0, 4);});
    }
    @Test//Assert IllegalArgumentException if "endWord" <= 0
    public void testGeSubStrings3() {
        manipulatedstring.setString("Throw me to the wolves and I will come back leading the pack");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(3, -4);});
    }
    @Test//Assert IllegalArgumentException if "startWord" > "endWord"
    public void testGeSubStrings4() {
        manipulatedstring.setString("Throw me to the wolves and I will come back leading the pack");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(3, 1);});
    }
    @Test//Assert IndexOutOfBoundsException If the string has less than "endWord" words in it
    public void testGeSubStrings5() {
        manipulatedstring.setString("Throw me to the wolves and I will come back leading the pack");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.getSubStrings(3, 14);});
    }
    @Test//Test with a string with more words for the proper behavior - Happy Path
    public void testGeSubStrings6() {
        manipulatedstring.setString("Throw me to the wolves and I will come back leading the pack");
        String [] sStings = manipulatedstring.getSubStrings(5, 13);

        assertEquals(sStings[0], "wolves");
        assertEquals(sStings[8], "pack");
    }

    @Test//Test basic restore operation/behaviour - Happy Path
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array = {1,0,2};
        //array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test//Assert IllegalArgumentException if not s.length == indices.length == n
    public void testRestoreString2()
    {
        int [] array;
        array=new int[]{1,0,2};
        manipulatedstring.setString("123456789");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.restoreString(array);});
    }

    @Test//Assert IndexOutOfBoundsException if indices[i]< 0
    public void testRestoreString3()
    {
        int [] array;
        array=new int[]{1,0,-2};
        manipulatedstring.setString("art");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});
    }

    @Test//Assert IndexOutOfBoundsException if indices[i]>= string length
    public void testRestoreString4()
    {
        int [] array;
        array=new int[]{1,0,3};
        manipulatedstring.setString("art");
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});
    }

    @Test//Test if restoreString() works with a larger shuffle array
    public void testRestoreString5()
    {
        int [] indices = {4, 5, 6,7, 0, 1, 2, 3};
        manipulatedstring.setString("UnitTest");
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals(restoreString, "TestUnit");
    }

    @Test//Test getString() returns the correct string - added for compliance with jacoco 100% test coverage
    public void testGetString()
    {
        manipulatedstring.setString("UnitTest");
        assertEquals("UnitTest", manipulatedstring.getString());
    }
}
