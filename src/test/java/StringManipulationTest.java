import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/*
    Sean Fite
    CS 410 Junit Testing Project
    This program runs Junit tests on StringManipulation.java
    Last Edited 6/7/23
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

    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // test func when string input is just 1 word
    @Test
    public void testCount2() {
        manipulatedstring.setString("This");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    // test func when string input is empty
    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // test func when string input has extra spaces
    @Test
    public void testCount4()
    {
        manipulatedstring.setString("as   I went    to the store");
        int length = manipulatedstring.count();
        assertEquals(6, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    // test case for deleting all the characters
    @Test
    public void testRemoveNthCharacter5()
    {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    // test case for nth character out of bounds
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("apple");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(10, true);
        });
    }

    // test case for n < 0
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("coffee");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(-1, true);
        });
    }

    // test case for n = 0
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("coffee");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(0, true);
        });
    }

    // test case for empty string
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(3, true);
        });
    }


    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // if start word > end word
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(4, 2);
        });
    }

    // if start word < 0
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(0, 2);
        });
    }

    // if end word < 0
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(2, 0);
        });
    }

    // if end word > amount of words
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is my string");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(2, 6);
        });
    }

    // if start and end indexes are the same
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 3);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], null);
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // testing for capital letter sensitivity
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("TestUnit");
        int [] array;
        array=new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "UnitTest");
    }

    // testing if input string length matches indices length
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("Test Unit");
        int [] array;
        array=new int[]{1, 0, 6, 7, 5, 4, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });

    }

    // testing if indices values > string input length
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("TestUnit");
        int [] array;
        array=new int[]{1, 0, 6, 7, 9, 4, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    // testing if indices value < 0
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("TestUnit");
        int [] array;
        array=new int[]{1, 0, -6, 7, 9, 4, 2, 3};
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

}

