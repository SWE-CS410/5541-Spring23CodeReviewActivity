/* Chris Nevares
 * 6/11/23
 * CS410, Spring 2023
 * Junit Testing Assignment - StringManipulationTest
 *
 * This is a test harness for the StringManipulation object.
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullEnum;
import org.junit.jupiter.params.provider.ValueSource;


import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import java.util.Objects;

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

    // Standard test to verify the function is working properly.
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    // Testing to verify the method does not regard punctuations as words.
    @Test
    public void testCount2() {
        manipulatedstring.setString("! !");
        int length = manipulatedstring.count();
        assertEquals(0, length);

    }

    //Another basic functionality test. Trying out the assertFalse assertion.
    @Test
    public void testCount3() {
        manipulatedstring.setString("This should equal 5 words... or should it?");
        int length = manipulatedstring.count();
        assertFalse(5==length);
    }

    // Verify count will return 0 when String length is 0.
    @Test
    public void testCount4() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // Testing strings with different punctuations and accented letters.
    @Test
    public void testCount5() {
        manipulatedstring.setString("¿Qué pasa?");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    // Testing combinations of alphanumeric characters and punctuations.
    @Test
    public void testCount6() {
        manipulatedstring.setString("1 3 4 7 8 1999 ???? ! word here");
        int length = manipulatedstring.count();
        assertEquals(8, length);
    }

    //Testing various combinations of 2 word strings
    @ParameterizedTest
    @ValueSource(strings = {"hello goodbye", "Two words", "adgsdgafgag asdaaga", "numb3rs, w0rds", "'Sup fam"})
    public void testCount7(String input) {
        manipulatedstring.setString(input);
        int length = manipulatedstring.count();
        assertEquals(2,length);
    }

    //Verify a NullPointerException is thrown when count is called on a null string.
    @Test
    public void testCount8() {
        assertThrows(NullPointerException.class,
                ()-> {manipulatedstring.count();});
    }

    // Test to check if removeNthCharacter is working when maintainSpacing is true.
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    // Test to check if method is outputting correctly when maintainSpacing = false.
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    // Verify if an IndexOutOfBoundsException is thrown when n > string length
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("TestString");
        assertThrows(IndexOutOfBoundsException.class, ()->
        {manipulatedstring.removeNthCharacter(15, false);});
    }

    // Verify an IllegalArgumentException is thrown when n < 0
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("TestString");
        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.removeNthCharacter(-1, false);});;
    }

    // Test to verify the method will remove the very last character if called and nothing else.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Let's check this test string.");
        int length = manipulatedstring.getString().length();
        String testString = manipulatedstring.removeNthCharacter(length, true);
        assertEquals("Let's check this test string " , testString);
    }

    // This test is to verify an empty string is correctly returned when parameters 1, false are passed.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Remove all characters from this string please and thank you.");
        String testString = manipulatedstring.removeNthCharacter(1, false);
        assertEquals("",testString);
    }

    // Test to verify that method will throw a NullPtrException if a string is not set.
    @Test
    public void testRemoveNthCharacter7() {
        assertThrows(NullPointerException.class, ()-> {
                    Objects.requireNonNull(manipulatedstring).removeNthCharacter(1, true);});

    }

    //Initial test with base requirements for getSubStrings.
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // Test to check if getSubStrings method will throw an IllegalArgumentException with invalid startWord.
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is a test string.");
        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(-1, 2);});

        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(0, 2);});
    }


    // Verify getSubStrings will throw an IllegalArgumentException when endWord <=0
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is a test string.");
        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(1,-1);});

        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(1, 0);});
    }

    //Test to verify that getSubStrings will throw an IllegalArgumentException
    // if startWord > endWord while both are valid inputs.
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is a test string.");
        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(4, 2);});
    }

    // This test is to verify getSubStrings will return a single (and correct) word
    // when startWord = endWord and the String array is the correct length.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("The word \'correct\' is the correct word.");
        String[] testString = manipulatedstring.getSubStrings(6, 6);
        String[] actualString = {"correct"};
        int length = testString.length;
        assertEquals(1, length);
        assertEquals(actualString[0], testString[0]);
    }

    // Test to verify words with "-" and "'" are correctly being recognized, while ignoring
    // punctuation.
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("'Sup? Let's use a medium-long string?");
        String[] array = manipulatedstring.getSubStrings(1,5);
        String[] expected = {"'Sup", "Let's", "use", "a", "medium-long"};
        assertArrayEquals(expected, array);
    }

    //Testing ParameterizedTest and show
    @ParameterizedTest
    @ValueSource( ints = {-1, 0})
    public void testGeSubStrings7(int input) {
        manipulatedstring.setString("This is a test string.");
        assertThrows(IllegalArgumentException.class, ()->
        {manipulatedstring.getSubStrings(input, 2);});
    }

    // Verify basic functionality of restoreString.
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("rat", restoreString);
    }

    //Verify restoreString will through IllegalArgumentException when
    // indices length != string length.
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("This is another test string.");
        int[] array = {0,3,4,5,6};
        assertThrows(IllegalArgumentException.class, ()->
                    {manipulatedstring.restoreString(array);});

    }

    // This test is to verify an IndexOutOfBounds exception is thrown when an
    // restoreString is called when element of the input array is negative.
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("Running out of string ideas.");
        int[] array = {28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,
                12,11,10,9,8,7,6,5,4,3,2,1,-1};
        assertThrows(IndexOutOfBoundsException.class, ()->
                {manipulatedstring.restoreString(array);});

    }

    // This test is to verify an IndexOutOfBounds exception is thrown when an
    // restoreString is called when element of the input array is greater than or equal
    // to string length.
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("Hi Mr. String.");
        int[] array = {14, 12,11,10,9,8,7,6,5,4,3,2,1,0};

        assertThrows(IndexOutOfBoundsException.class, ()->
        {manipulatedstring.restoreString(array);});

        int[] array2 = {13,12,11,10,9,8,98,6,5,4,3,2,1,0};

        assertThrows(IndexOutOfBoundsException.class, ()->
        {manipulatedstring.restoreString(array2);});

    }

    // This test is to check to make sure that restoreString does not modify or change
    // the original string stored in the object.
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("This is a test.");
        String actualString = manipulatedstring.getString();
        int[] array = {10, 11,12,13,4,5,6,7,8,9,0,1,2,3,14};
        String testString = manipulatedstring.restoreString(array);


        assertNotEquals(actualString, testString);

    }

    //Testing ParameterizedTest and CSVSource
    @ParameterizedTest
    @CsvSource({"2,1,3,4,5,0, balest", "5,4,1,2,3,0, seablt"})
    public void testRestoreString6(int a, int b, int c, int d, int e, int f, String s) {
        int[] array = {a,b,c,d,e,f};
        manipulatedstring.setString("tables");
        String testString = manipulatedstring.restoreString(array);
        assertEquals(s,testString);


    }

}
