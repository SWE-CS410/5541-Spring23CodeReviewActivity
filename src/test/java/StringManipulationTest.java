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

    /**
     * This test is just for the string input that contains just spaces or an
     * empty string
     *
     * */
    @Test
    public void testCount2() {
        manipulatedstring.setString("  ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    /**
     * This is a test for string inputs with null value or
     * if the string hasn't been set
     *
     * */
    @Test
    public void testCount3() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.setString(null);
            manipulatedstring.count();
        });

        String expectedMessage = "String is null.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * this test is to test the elimination of the punctuation marks as they are not words
     * and to test the
     * */
    @Test
    public void testCount4() {
        manipulatedstring.setString("this is hello world, !!!!! ");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }
    /**
     * this is to test the elimination of the spaces before and after the String data
     * in counting the words
     * */
    @Test
    public void testCount5() {
        manipulatedstring.setString(" This is hello world. !!!!! ");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }
    /**
     * This is to test if the removal of every nth term did take place
     * */
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }
    /**
     *This is to test if the replacement of every nth term did take place with
     * the space character
     * */
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }
    /**
     *  this is to test for IndexOutOfBoundsException
     * */
    @Test
    public void testRemoveNthCharacter3() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
            manipulatedstring.removeNthCharacter(300, true);
        });

        String expectedMessage = "n must be less than the length of the string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    /**
     *this is to test for IllegalArgumentException for negative n value
     * */
    @Test
    public void testRemoveNthCharacter4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
            manipulatedstring.removeNthCharacter(-300, true);
        });

        String expectedMessage = "n must be greater than 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
    /**
     *this is to test for IllegalArgumentException for 0 as for n value
     * */
    @Test
    public void testRemoveNthCharacter5() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
            manipulatedstring.removeNthCharacter(0, true);
        });

        String expectedMessage = "n must be greater than 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    /**
     *  this is to test to handle null as just to return null of the string
     *  data hasn't been setup yet. i could retrn "" but i chose null to show
     *  null data type
     * */
    @Test
    public void testRemoveNthCharacter6() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            manipulatedstring.setString(null);
            manipulatedstring.removeNthCharacter(3, true);
        });

        String expectedMessage = "String is null.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     *
     * */
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
    /**
     *
     * */
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(2, 4);

        assertEquals(sStings[0], "is");
        assertEquals(sStings[1], "my");
        assertEquals(sStings[2], "string");
    }
    /**
     *  this test is to check if the negative or 0 inputs produce
     *  the IllegalArgumentException
     *
     * */
    @Test
    public void testGeSubStrings3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("This is my string");
            String [] sStings = manipulatedstring.getSubStrings(0, -4);

        });

        String expectedMessage = "start word or end word is invalid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    /**
     *this test is to check if the endword is greater than the startword inputs produce
     *  the IllegalArgumentException
     * */
    @Test
    public void testGeSubStrings4() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            manipulatedstring.setString("This is my string");
            String [] sStings = manipulatedstring.getSubStrings(4, 3);
        });

        String expectedMessage = "start word or end word is invalid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    /**
     * this is to check if the string has less than "endWord" words in it
     * */
    @Test
    public void testGeSubStrings5() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            manipulatedstring.setString("This is my string");
            String [] sStings = manipulatedstring.getSubStrings(3, 6);
        });

        String expectedMessage = "string has less than endWord words in it";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    /**
     *  this is to test if the restoration works on a normal
     *  circumstance
     * */
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }
    /**
     * this test is to check the IllegalArgumentException if not s.length == indices.length == n
     * */
    @Test
    public void testRestoreString2()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.setString("art");
            int [] array;
            array=new int[]{1,0,2,3};
            String restoreString = manipulatedstring.restoreString(array);
        });

        String expectedMessage = "not s.length == indices.length == n";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
    /**
     *this test is to check the IndexOutOfBoundsException if
     *  indices[i]< 0  or  indices[i]> string length
     * */
    @Test
    public void testRestoreString3()
    {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.setString("art");
            int [] array;
            array=new int[]{1,0,20};
            String restoreString = manipulatedstring.restoreString(array);
        });

        String expectedMessage = "indices[i]< 0  or  indices[i]> string length";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
    /**
     * To check for null pointer if the string has not been set yet
     * or is null
     * */
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString(null);
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);

    }


}
