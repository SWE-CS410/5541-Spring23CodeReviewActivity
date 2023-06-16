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

    /**
     * Check whether a simple string of space-separated words is counted correctly.
     */
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    /**
     * Check whether an empty string is correctly counted as zero.
     */
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        assertEquals(0, manipulatedstring.count());
    }

    /**
     * Check whether a single letter string is correctly counted as one.
     */
    @Test
    public void testCount3() {
        manipulatedstring.setString("A");
        assertEquals(1, manipulatedstring.count());
    }

    /**
     * Check whether a string of multiple spaces is correctly counted as zero.
     */
    @Test
    public void testCount4() {
        manipulatedstring.setString("   ");
        assertEquals(0, manipulatedstring.count());
    }

    /**
     * Check whether every third character is correctly removed (not maintaining spacing) in a simple scenario.
     */
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    /**
     * Check whether every third character is correctly replaced with spaces in a simple scenario.
     */
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    /**
     * Check whether an out of bounds exception is correctly thrown when n is over the string length.
     */
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("A b c d e");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(10, false));
    }

    /**
     * Check whether an illegal argument exception is correctly thrown when n is negative.
     */
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("A b c d e");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1, false));
    }

    /**
     * Check whether whitespace is removed correctly too.
     */
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("A\nb\tc\nd\te\n");
        assertEquals("Abcde", manipulatedstring.removeNthCharacter(2, false));
    }

    /**
     * Check whether a single character is correctly replaced with a single space if n is one and spacing is maintained.
     */
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("a");
        assertEquals(" ", manipulatedstring.removeNthCharacter(1, true));
    }

    /**
     * Check whether an illegal argument exception is correctly thrown if n is zero AND the string is empty.
     */
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, false));
    }

    /**
     * Check whether a simple string of words is correctly turned into substrings.
     */
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    /**
     * Check whether an illegal argument exception is correctly thrown when one of the string indices is zero.
     */
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("a b c d");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(0, 1));
    }

    /**
     * Check whether an illegal argument exception is correctly thrown when the second index is lower than the first.
     */
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("a b c d");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(2, 1));
    }
    /**
     * Check whether an out of bounds exception is correctly thrown when the right index is higher than the number of
     * words.
     */
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("a b c d");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(2, 5));
    }

    /**
     * Check whether a single string is correctly returned when the indices are the same and there is only
     * one word.
     */
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("abc");
        assertEquals("abc", manipulatedstring.getSubStrings(1, 1)[0]);
    }

    /**
     * Check whether an out of bounds exception is correctly thrown for a string of whitespace with nonzero indices.
     */
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("   ");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 1));
    }

    /**
     * Check whether a simple string with words separated by multiple spaces is correctly converted to substrings.
     */
    @Test
    public void testGeSubStrings7() {
        manipulatedstring.setString("This    is    my   string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);
        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    /**
     * Check whether a simple string can be rearranged correctly.
     */
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
     * Check whether a simple string can be correctly rearranged into all the same letter (this wasn't part of the spec
     * but I am making the executive decision to include it).
     */
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("abc");
        int [] array = new int[]{2,2,2};
        assertEquals(manipulatedstring.restoreString(array), "ccc");
    }

    /**
     * Check whether an illegal argument exception is correctly thrown when the number of indices doesn't match
     * the number of letters in the string.
     */
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("abcd");
        int [] array = new int[]{1,2,3};
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array));
    }
    /**
     * Check whether an illegal argument exception is correctly thrown when one of the indices is higher than the
     * string length.
     */
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("abc");
        int [] array = new int[]{1,2,3};
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array));
    }

    /**
     * Check whether a string with non-alphanumeric characters can be successfully rearranged. (Also not part
     * of the spec, but my implementation does it anyway and I wanted to test it.)
     */
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("A 1");
        int [] array = new int[]{2,0,2};
        assertEquals(manipulatedstring.restoreString(array), "1A1");
    }

}
