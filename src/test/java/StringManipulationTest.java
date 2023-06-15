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

//    This test checks basic functionality for the count()
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

//    This test checks whether method can handle variation
    @Test
    public void testCount2() {
        manipulatedstring.setString("String test with a word");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

//    This test checks whether method can handle numbers
    @Test
    public void testCount3() {
        manipulatedstring.setString("String test with a number 1");
        int length = manipulatedstring.count();
        assertEquals(6, length);
    }

//    This test checks whether space at the front and multiple spaces affects functionality
    @Test
    public void testCount4() {
        manipulatedstring.setString("     String       test       with        spaces           ");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

//    This test checks extreme cases with different spacings and multiple numbers
    @Test
    public void testCount5() {
        manipulatedstring.setString("    String     tests  with  numbers  1234         ");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

//    This test checks empty string with spaces
    @Test
    public void testCount6() {
        manipulatedstring.setString("          ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

//    This test checks one character
    @Test
    public void testCount7() {
        manipulatedstring.setString("     a     ");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

//    This test checks the basic functionality
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

//    This test checks the manipulatedstring
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

//    This test checks different variable for n
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Testing to see the remove Nth Character");
        assertEquals("Tsigt e h eoeNhCaatr", manipulatedstring.removeNthCharacter(2, false));
    }

//    This test checks whether method removeNthCharacter() suitably throws an IllegalArgumentException if n is less than or equal to zero
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Testing to see the remove Nth Character");
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    manipulatedstring.removeNthCharacter(0, false);
                }, "n can not be less than or equal to zero");
    }

//    This test checks whether method removeNthCharacter() suitably throws an IllegalArgumentException if n is less than or equal to zero when maintainspacing is true
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Testing to see the remove Nth Character");
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    manipulatedstring.removeNthCharacter(0, true);
                }, "n can not be less than or equal to zero");
    }

//    This test checks whether method removeNthCharacter() suitably throws an IndexOutOfBoundsException if n is greater than the string length
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("The length of this string is 31");
        IndexOutOfBoundsException thrown =
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    manipulatedstring.removeNthCharacter(32, false);
                }, "n is greater than the string length");
    }

//    This test checks whether method removeNthCharacter() suitably throws an IndexOutOfBoundsException if n is greater than the string length when maintainspacing is true
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("The length of this string is 31");
        IndexOutOfBoundsException thrown =
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    manipulatedstring.removeNthCharacter(32, true);
                }, "n is greater than the string length");
    }

//    This test checks the basic functionality of the method
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

//    This test checks the basic functionality of the method with different range
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string with more words");
        String [] sStings = manipulatedstring.getSubStrings(2, 6);

        assertEquals(sStings[0], "is");
        assertEquals(sStings[1], "my");
        assertEquals(sStings[2], "string");
        assertEquals(sStings[3], "with");
        assertEquals(sStings[4], "more");
    }

//    This test checks whether method getSubStrings() suitably throws an IndexOutOfBoundsException when index is out of bound
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This string contains 5 words");
        IndexOutOfBoundsException thrown =
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(1, 6);
                }, "index is out of bound");
    }

//    This test checks whether method getSubStrings() suitably throws an IndexOutOfBoundsException when index is out of bound
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This string contains 5 words");
        IndexOutOfBoundsException thrown =
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(6, 7);
                }, "index is out of bound");
    }

//    This test checks whether method getSubStrings() suitably throws an IllegalArgumentException when invalid input for index
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This string contains 5 words");
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(0, 4);
                }, "invalid input for index");
    }

//    This test checks whether method getSubStrings() suitably throws an IllegalArgumentException when startWord value is larger then endWord
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This string contains 5 words");
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(3, 2);
                }, "invalid input for index");
    }

//    This test checks the basic functionality of the method
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

//    This test checks the given example
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("UnitTest");
        int[] indicis = {4,5,6,7,0,2,1,3};
        assertEquals("TsetUnit", manipulatedstring.restoreString(indicis));
    }

//    This test checks different arrangement
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("Shuffle Up");
        int[] indicis = {1,6,2,0,5,7,3,4,8,9};
        assertEquals("fSue fhlUp", manipulatedstring.restoreString(indicis));
    }

//    This test checks whether method restoreString() suitably throws an IllegalArgumentException when index values does not match the string
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("The string length is 23");
        int[] indicis = {0,1,2,3};
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    String Sting = manipulatedstring.restoreString(indicis);
                }, "index values does not match the string");
    }

//    This test checks whether method restoreString() suitably throws an IllegalArgumentException when index values does not match the string
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("The string length is 23");
        int[] indicis = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    String Sting = manipulatedstring.restoreString(indicis);
                }, "index values does not match the string");
    }

//    This test checks whether method restoreString() suitably throws an IndexOutOfBoundsException when invalid index input
    @Test
    public void testRestoreString6()
    {
        manipulatedstring.setString("TEST");
        int[] indicis = {0,-1, 2, 3};
        IndexOutOfBoundsException thrown =
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    String Sting = manipulatedstring.restoreString(indicis);
                }, "invalid index input");
    }
}
