import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    //Checks to see if default value for non-null/empty strings is 1
    @Test
    public void testCount2() {
    	manipulatedstring.setString("Hello");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    	
    }
    //Checks to ensure that it properly measures null strings as 0 words
    @Test
    public void testCount3() {
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }
    //Checks to see if it's counting multiple spaces as multiple words. 
    @Test
    public void testCount4() {
    	manipulatedstring.setString("This   checks    for    long   spaces");
    	int length = manipulatedstring.count();
    	assertEquals(5, length);
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

    //checks to see if it throws exception when the index is larger than the number of chars
    @Test
    public void testRemoveNthCharacter3() {
    
    	manipulatedstring.setString("Hello");
    	Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.removeNthCharacter(12, true); });

    }
    //Checks for exception when -1, an illegal argument, is passed. 
    @Test
    public void testRemoveNthCharacter4() {
    	manipulatedstring.setString("Hello");
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(-1, true); });

    }
    //Testing to see if it will properly remove all chars when value is 1.
    @Test
    public void testRemoveNthCharacter5() {
    	manipulatedstring.setString("Hello");
        assertEquals("     ", manipulatedstring.removeNthCharacter(1, true));
    }
    //testing to see if it properly removes the last character of the string when the input number is a factor of the string length
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Ten Chars!");
        assertEquals("Ten  hars ", manipulatedstring.removeNthCharacter(5,true));
    }
    //Testing to check whole string iteration, like test 5 without maintaining spacing. 
    @Test
    public void testRemoveNthCharacter7() {
    	manipulatedstring.setString("Hello");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
    //Checks for index out of bound exception being thrown
    @Test
    public void testGeSubStrings2() {
    	manipulatedstring.setString("This is my string");
    	Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.getSubStrings(1, 5);});
    }
    //checks for startWord being <= 0 throwing an exception
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("test with many words for exceptions");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(0, 1);});
        String expected = "startWord must be greater than zero";
        String actual = exception.getMessage();
        assertTrue(actual == expected);
    }
    //checks for endWord being <= 0 throwing an exception
    @Test
    public void testGeSubStrings4() {
    	manipulatedstring.setString("test with many words for exceptions");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(1, 0);});
        String expected = "endWord must be greater than zero";
        String actual = exception.getMessage();
        assertTrue(actual == expected);
    }
    //Checks for endWord being less than startWord throwing an exception
    @Test
    public void testGeSubStrings5() {
    	manipulatedstring.setString("test with many words for exceptions");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.getSubStrings(4, 2);});
        String expected = "endWord must not be less than startWord";
        String actual = exception.getMessage();
        assertTrue(actual == expected);
    }
    //Checks to see how well it works on a string with many words. 
    @Test
    public void testGeSubStrings6() {
    	manipulatedstring.setString("This is a long string");
        String [] sStrings = manipulatedstring.getSubStrings(1, 5);

        assertEquals(sStrings[0], "This");
        assertEquals(sStrings[1], "is");
        assertEquals(sStrings[2], "a");
        assertEquals(sStrings[3], "long");
        assertEquals(sStrings[4], "string");
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

    //checks to see if it throws an exception when an array that is shorter than the string size is passed
    @Test
    public void testRestoreString2()
    {
    	manipulatedstring.setString("short");
    	int[] array = {1, 2, 3};
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.restoreString(array);});

    }
    //checks to see if an exception is thrown when an index over the string length is passed
    @Test
    public void testRestoreString3()
    {
    	manipulatedstring.setString("short");
    	int[] array = {1, 2, 3, 4, 5};
    	Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});

    }
    //checks to see if exception is thrown when index below 0 is thrown. 
    @Test
    public void testRestoreString4()
    {
    	manipulatedstring.setString("short");
    	int[] array = {1, 2, 3, 4, -1};
    	Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.restoreString(array);});
    }
    //test for longer, more complex usage of restore string, to check if method works (actually did catch that it wasn't quite right, so it worked.)
    @Test
    public void testRestoreString5()
    {
    	manipulatedstring.setString("ixemdpusllyiingstr   ");
        int [] array;
        array=new int[]{1, 2, 3, 0, 4, 7, 6, 9, 11, 12, 13, 10, 18, 19, 20, 15, 16, 17, 5, 8, 14};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "mixed up silly string");

    }

}
