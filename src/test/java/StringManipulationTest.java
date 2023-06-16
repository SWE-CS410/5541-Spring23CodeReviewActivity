import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedString;

    @BeforeEach
    public void setUp() {
        manipulatedString = new StringManipulation();
    }

    @AfterEach
    public void tearDown() {
        manipulatedString = null;
    }

    @Test
    public void testCount1() {
    	int length = manipulatedString.count();
    	assertEquals(-1, length);
    }

    @Test
    public void testCount2() {
    	manipulatedString.setString("");
    	int length = manipulatedString.count();
    	assertEquals(0, length);
    }

    @Test
    public void testCount3() {
        manipulatedString.setString("Thisismystring");
        int length = manipulatedString.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
        manipulatedString.setString("This is my string");
        int length = manipulatedString.count();
        assertEquals(4, length);
    }
    
    @Test
    public void testRemoveNthCharacter1() {
        Exception e = assertThrows(NullPointerException.class, () -> { manipulatedString.removeNthCharacter(3, false); });
        assertEquals(e.getMessage(), "String has not been set for current StringManipulation object (hint: use setString()).");
    }
    
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        Exception e = assertThrows(IllegalArgumentException.class, () -> { manipulatedString.removeNthCharacter(0, false); });
        assertEquals(e.getMessage(), "First argument is less than or equal to zero.");
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        int n = 50;
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> { manipulatedString.removeNthCharacter(n, false); });
        assertEquals(e.getMessage(), "Passed " + n + " as first argument. " + n + " is greater than length of current StringManipulation object: " + manipulatedString.getString().length());
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", manipulatedString.removeNthCharacter(1, false));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("                                                 ", manipulatedString.removeNthCharacter(1, true));
    }

    @Test
    public void testRemoveNthCharacter6() {
    	manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedString.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedString.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedString.removeNthCharacter(3, true));
    }

    @Test
    public void testGetSubStrings1() {
        Exception e = assertThrows(NullPointerException.class, () -> { manipulatedString.getSubStrings(3, 4); });
        assertEquals(e.getMessage(), "String has not been set for current StringManipulation object (hint: use setString()).");
    }

    @Test
    public void testGetSubStrings2() {
        manipulatedString.setString("This is my string");
        Exception e = assertThrows(IllegalArgumentException.class, () -> { manipulatedString.getSubStrings(0, 4); });
        assertEquals(e.getMessage(), "Index for startWord (first argument) must be greater than or equal to 1.");
    }
    
    @Test
    public void testGetSubStrings3() {
        manipulatedString.setString("This is my string");
        Exception e = assertThrows(IllegalArgumentException.class, () -> { manipulatedString.getSubStrings(3, 0); });
        assertEquals(e.getMessage(), "Index for endWord (second argument) must be greater than or equal to 1.");
    }
    
    @Test
    public void testGetSubStrings4() {
        manipulatedString.setString("This is my string");
        Exception e = assertThrows(IllegalArgumentException.class, () -> { manipulatedString.getSubStrings(4, 3); });
        assertEquals(e.getMessage(), "Index for startWord (first argument) must be less than index for endWord (second argument).");
    }
    
    @Test
    public void testGetSubStrings5() {
        manipulatedString.setString("This is my string");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> { manipulatedString.getSubStrings(3, 5); });
        assertEquals(e.getMessage(), "Index of endWord is greater than word count for current StringManipulation object.");
    }
    
    @Test
    public void testGetSubStrings6() {
        manipulatedString.setString("This is my string");
        String[] substrings = manipulatedString.getSubStrings(3, 4);

        assertEquals(substrings[0], "my");
        assertEquals(substrings[1], "string");
    }

    @Test
    public void testRestoreString1() {
        int[] array = { 1, 0, 2 };
        Exception e = assertThrows(NullPointerException.class, () -> { manipulatedString.restoreString(array); });
        assertEquals(e.getMessage(), "String has not been set for current StringManipulation object (hint: use setString()).");
    }

    @Test
    public void testRestoreString2() {
    	manipulatedString.setString("art");
        int[] array = { 1, 0, 2, 3 };
        Exception e = assertThrows(IllegalArgumentException.class, () -> { manipulatedString.restoreString(array); });
        assertEquals(e.getMessage(), "Length mismatch between number of words in current StringManipulation object and length of given indices array.");
    }

    @Test
    public void testRestoreString3() {
    	manipulatedString.setString("art");
        int[] array = { 1, 0, 2 };
        int targetIdx = 0;
        array[targetIdx] = -1;
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> { manipulatedString.restoreString(array); });
        assertEquals(e.getMessage(), "Invalid index: Element at index " + targetIdx + " in passed array is less than zero.");
    }

    @Test
    public void testRestoreString4() {
    	manipulatedString.setString("art");
        int[] array = { 1, 0, 2 };
        int targetIdx = 0;
        array[targetIdx] = 3;
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> { manipulatedString.restoreString(array); });
        assertEquals(e.getMessage(), "Invalid index: Element at index " + targetIdx + " in passed array is GTE the length of the current StringManipulation object.");
    }

    @Test
    public void testRestoreString5() {
        manipulatedString.setString("art");
        int[] array = { 1, 0, 2 };
        String restoredString = manipulatedString.restoreString(array);
        assertEquals(restoredString, "rat");
    }
}
