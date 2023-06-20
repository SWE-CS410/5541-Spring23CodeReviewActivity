import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testCount2() {
        manipulatedstring.setString("This string has five words");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString(null);
        int length = manipulatedstring.count();
        assertEquals(0, length);
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

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Hello World!");
        String result = manipulatedstring.removeNthCharacter(1, false);
        assertEquals("", result);
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Hello World!");
        String result = manipulatedstring.removeNthCharacter(2, true);
        assertEquals("H l o W r d ", result);
    }

    @Test
    public void testRemoveNthCharacter5() {
        try {
            manipulatedstring.removeNthCharacter(0, true);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Test passes if this exception is thrown
        }
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Hello");
        try {
            manipulatedstring.removeNthCharacter(10, false);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Test passes if this exception is thrown
        }
    }


    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString(null);
        String result = manipulatedstring.removeNthCharacter(1, false);
        assertNull(result);
    }


    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is a longer string that has more than four words");
        String [] subStrings = manipulatedstring.getSubStrings(5, 7);

        assertEquals(subStrings[0], "string");
        assertEquals(subStrings[1], "that");
        assertEquals(subStrings[2], "has");
    }

    @Test
    public void testGeSubStrings3() {
        try {
            manipulatedstring.getSubStrings(0, 1);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Test passes if this exception is thrown
        }
    }

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is a string");
        try {
            manipulatedstring.getSubStrings(1, 5);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Test passes if this exception is thrown
        }
    }


    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString(null);
        String[] result = manipulatedstring.getSubStrings(1, 1);
        assertNull(result);
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("");
        String[] result = manipulatedstring.getSubStrings(1, 1);
        assertEquals(1, result.length);
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

    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("unittest");
        int [] array = {0,1,2,3,4,5,6,7};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "unittest");
    }

    @Test
    public void testRestoreString3() {
        try {
            manipulatedstring.setString("unittest");
            int [] array = {0,1,2};
            manipulatedstring.restoreString(array);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Test passes if this exception is thrown
        }
    }

    @Test
    public void testRestoreString4() {
        try {
            manipulatedstring.setString("unittest");
            int [] array = {0,1,2,3,4,5,6,8};
            manipulatedstring.restoreString(array);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Test passes if this exception is thrown
        }
    }


    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString(null);
        int [] array = {0,1,2};
        String result = manipulatedstring.restoreString(array);
        assertNull(result);
    }

}
