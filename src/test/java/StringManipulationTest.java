//Alvin Bautista
//CS 410 - JUNIT Assignment
//06112023

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedString; //object to be tested

    @BeforeEach
    public void setUp() {
        manipulatedString = new StringManipulation(); //initialize object before each test
    }

    @AfterEach
    public void tearDown() {
        manipulatedString = null; //cleanup after each test
    }

    @Test
    public void testCount1() {
        manipulatedString.setString("This is my string"); //setting string
        int length = manipulatedString.count(); //count words
        assertEquals(4, length); //assert expected value
    }

    @Test
    public void testCount2() {
        manipulatedString.setString("One more test case"); //setting string
        assertEquals(4, manipulatedString.count()); //directly asserting expected value
    }

    @Test
    public void testCount3() {
        manipulatedString.setString(""); //setting empty string
        assertEquals(0, manipulatedString.count()); //asserting count is 0
    }

    @Test
    public void testCount4() {
        manipulatedString.setString("Single"); //setting single word
        assertEquals(1, manipulatedString.count()); //asserting count is 1
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?"); //setting string
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedString.removeNthCharacter(3, false)); //asserting removal of characters
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?"); //setting string
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedString.removeNthCharacter(3, true)); //asserting removal with spaces
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedString.setString("Example text for test case."); //setting string
        assertEquals("Eapetx o etcs.", manipulatedString.removeNthCharacter(2, false)); //asserting removal of characters
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedString.setString("Example text for test case."); //setting string
        assertEquals("Example text for test case.", manipulatedString.removeNthCharacter(1, false)); //asserting no change for n=1
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedString.setString("Small"); //setting string
        assertEquals("Sal", manipulatedString.removeNthCharacter(2, false)); //asserting removal of characters
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedString.setString("Small"); //setting string
        assertEquals("S a l", manipulatedString.removeNthCharacter(2, true)); //asserting removal with spaces
    }

    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.removeNthCharacter(20, true)); //asserting exception for out of bounds
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedString.setString("This is my string"); //setting string
        String [] sStings = manipulatedString.getSubStrings(3, 4); //get substring array

        assertEquals(sStings[0], "my"); //asserting elements
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGetSubStrings2() {
        manipulatedString.setString("A B C D E"); //setting string
        String[] subStrings = manipulatedString.getSubStrings(2, 4); //get substring array
        assertEquals("B", subStrings[0]); //asserting elements
        assertEquals("C", subStrings[1]);
        assertEquals("D", subStrings[2]);
    }

    @Test
    public void testGetSubStrings3() {
        manipulatedString.setString("One Two"); //setting string
        String[] subStrings = manipulatedString.getSubStrings(1, 2); //get substring array
        assertEquals("One", subStrings[0]); //asserting elements
        assertEquals("Two", subStrings[1]);
    }

    @Test
    public void testGetSubStrings4() {
        assertThrows(IllegalArgumentException.class, () -> manipulatedString.getSubStrings(3, 2)); //asserting exception for invalid arguments
    }

    @Test
    public void testGetSubStrings5() {
        manipulatedString.setString("Short"); //setting string
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedString.getSubStrings(1, 2)); //asserting exception for out of bounds
    }

    @Test
    public void testGetSubStrings6() {
        manipulatedString.setString("Just One"); //setting string
        String[] subStrings = manipulatedString.getSubStrings(1, 1); //get substring array
        assertEquals("Just", subStrings[0]); //asserting element
    }

    @Test
    public void testRestoreString1() {
        manipulatedString.setString("art"); //setting string
        int[] array = {1, 0, 2}; //indices array
        String restoreString = manipulatedString.restoreString(array); //restoring string
        assertEquals(restoreString, "rat"); //asserting restored string
    }

    @Test
    public void testRestoreString2() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedString.setString("invalid"); //setting string
            int[] array = {1, 0}; //invalid indices array
            manipulatedString.restoreString(array); //should throw exception
        });
    }

    @Test
    public void testRestoreString3() {
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedString.setString("outofbounds"); //setting string
            int[] array = {1, 0, 20}; //out of bounds indices array
            manipulatedString.restoreString(array); //should throw exception
        });
    }

    @Test
    public void testRestoreString4() {
        // Test case to verify the restoreString() method when the input string is "team"
        manipulatedString.setString("team");
        // and the indices array is {-1, 0, 1, 2}.
        int[] array = new int[]{-1, 0, 1, 2};
        // It should throw an IndexOutOfBoundsException.
        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedString.restoreString(array);});
    }

    @Test
    public void testRestoreString5(){
        // Test case to verify the restoreString() method when the input string is "group"
        manipulatedString.setString("group");
        // and the indices array is {5, 0, 1, 2, 3}.
        int[] array = new int[]{5, 0, 1, 2, 3};
        // It should throw an IndexOutOfBoundsException.
        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedString.restoreString(array);});
    }

    @Test
    public void testRestoreString6() {
        // Test case to verify the restoreString() method when the input string is null
        manipulatedString.setString(null);
        // and the indices array is {2, 3, 5, 4, 1, 0}.
        int[] array = new int[]{2, 3, 5, 4, 1, 0};
        // It should throw a NullPointerException.
        assertThrows(NullPointerException.class, ()->{manipulatedString.restoreString(array);});
    }

    @Test
    public void testRestoreString7() {
        // Test case to verify the restoreString() method when the input string is "MASTER"
        manipulatedString.setString("MASTER");
        // and the indices array is {2, 3, 5, 4, 1, 0}.
        int[] array = new int[]{2, 3, 5, 4, 1, 0};
        // It should return the expected output "STREAM".
        assertEquals("STREAM", manipulatedString.restoreString(array));
    }

}