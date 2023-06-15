/////////////////////////////////////////////////////////
//
//  Class: StringManipulationTest
//  Author: Caleb Rector
//  Date: 6/11/2023
// 
//  Description: Provides test cases for methods found in StringManipulation class
//
/////////////////////////////////////////////////////////

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Tests single word string
    @Test
    public void testCount2() {
        manipulatedstring.setString("OneWord");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    // Tests number of words in empty string
    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Tests number of words in string with newline characters
    @Test
    public void testCount4() {
        manipulatedstring.setString("Including\nsome\nnewline\ncharacters");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?",
                manipulatedstring.removeNthCharacter(3, true));
    }

    // Tests string with newline characters
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Seeing what happens when\nnewline characters are introduced"); // Newline character counts as character
        assertEquals("See ng  hat hap ens whe \nne lin  ch rac ers are int odu ed", manipulatedstring.removeNthCharacter(4, true));
    }

    // Tests large value for n
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("What happens when n is a much larger value?");
        assertEquals("What happns when nis a muchlarger vaue?", manipulatedstring.removeNthCharacter(10, false));
    }

    // Tests n = 1 (all characters should be replaced with a space)
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("What happens if n is 1?");
        assertEquals("                       ", manipulatedstring.removeNthCharacter(1, true));
    }

    // Tests whether method throws error when n = 0
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("An exception should be thrown if n = 0");
        try {
            manipulatedstring.removeNthCharacter(0, false);
            fail("No exception thrown for n=0");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }

    // Tests whether method throws error when n > length
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("An exception should ALSO be thrown if n > length");
        try {
            manipulatedstring.removeNthCharacter(100, false);
            fail("No exception thrown for n > length");
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("Lets see what happens when we pass in a string with lots and lots of words");
        String[] substrings = manipulatedstring.getSubStrings(4, 10);
        assertEquals(substrings[0], "happens");
        assertEquals(substrings[3], "pass");
        assertEquals(substrings[6], "string");
    }

    // Tests a string with newline characters
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Trying out some\nnewline characters");
        String[] subStrings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(subStrings[0], "some");
        assertEquals(subStrings[1], "newline");
    }

    // Tests a string with numbers and symbols
    @Test
    public void testGeSubStrings4() {
        manipulatedstring
                .setString("Special characters! Punctuation, symbols !@#$ and numbers 91283... Will it matter?");
        String[] substrings = manipulatedstring.getSubStrings(2, 10);
        assertEquals(substrings[0], "characters!");
        assertEquals(substrings[3], "!@#$");
        assertEquals(substrings[6], "91283...");
    }

    // Test whether exceptions are thrown when startWord > endWord or when one of the variables is < 0
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("SURELY nothing will go wrong if startWord is greater than endWord...");

        try {
            manipulatedstring.getSubStrings(6, 2);
            fail("No exception thrown");
        } catch (IllegalArgumentException e) {
        }

        try {
            manipulatedstring.getSubStrings(-1, 2);
            fail("No exception thrown");
        } catch (IllegalArgumentException e) {
        }

        try {
            manipulatedstring.getSubStrings(0, -3);
            fail("No exception thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    // Tests whether an exception is thrown when endWord is out of bounds
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("Last test. Out of bounds?");
        try {
            manipulatedstring.getSubStrings(0, 10);
            fail("Out of bounds exception not thrown");
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }

    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int[] array;
        array = new int[] { 1, 0, 2 };
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // Tests a longer string
    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("calebrector");
        int[] array = new int[] {0, 5, 1, 4, 3, 2, 6, 7, 8, 9, 10};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "crabelector");
    }

    // Tests another longer string
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("clinteAstWOod");
        int[] array = new int[] {10, 1, 12, 9, 5, 7, 8, 6, 0, 8, 2, 11, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "OldWestAction");
    }

    // Tests whether capitalization is preserved
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("CAPStest");
        int[] array = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "testCAPS");
    }

    // Tests whether exceptions are thrown when an index is negative or out of bounds
    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("Exceptions");

        try
        {
            int[] array = new int[] {0, 2};
            manipulatedstring.restoreString(array);
            fail("No exception thrown");
        }
        catch (IllegalArgumentException e) {}

        try
        {
            int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, -10};
            manipulatedstring.restoreString(array);
            fail("No exception thrown");
        }
        catch (IndexOutOfBoundsException e) {}
        try
        {
            int[] array = new int[] {0, 1, 2, 3, 400, 5, 6, 7, 8, 9};
            manipulatedstring.restoreString(array);
            fail("No exception thrown");
        }
        catch (IndexOutOfBoundsException e) {}
        
        assert true;
    }

}
