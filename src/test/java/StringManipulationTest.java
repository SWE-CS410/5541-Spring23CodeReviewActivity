
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

    // This test checks if the method returns zero as the count of words
    // when the given string only contains spaces.
    @Test
    public void testCount2() {
        manipulatedstring.setString("  ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // This test checks if the method properly returns the number of words
    // when the string contains a question mark, a comma, and a period in addition to spaces.
    @Test
    public void testCount3() {

        manipulatedstring.setString("How many words is this? It can count correctly, I hope.");
        int length = manipulatedstring.count();
        assertEquals(11, length);
    }

    // This test checks if the method properly returns the number of words
    // when the string contains a colon and a space.
    @Test
    public void testCount4() {
        manipulatedstring.setString("Item: 4");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    // This test checks if method returns zero when the manipulatedstring is set to
    // an empty string
    @Test
    public void testCount5() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // This test checks if the method throws NullPointerException if the count() is called
    // on the string that has been set to null
    @Test
    public void testCount6() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, ()->{manipulatedstring.count();});
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

    // This test checks if the method throws NullPointerException if the string has been set to null.
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, ()->{manipulatedstring.removeNthCharacter(1, true);});
    }

    // This test checks if the method throws IllegalArgumentException if n is 0.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I'm a CS student.");
        assertThrows(IllegalArgumentException.class, () -> {manipulatedstring.removeNthCharacter(0, true);});
    }
    //This test checks if the method throws IndexOutOfBoundsException if n is
    // greater than the length of the string
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("I live in Seattle.");
        // nValue holds the length of the string plus one
        int nValue = manipulatedstring.toString().length() + 1;
        assertThrows(IndexOutOfBoundsException.class, () -> {manipulatedstring.removeNthCharacter(nValue, false);});
    }
    // This test checks if the method removes all the characters without any spaces left
    // if n is 1 and maintainSpacing is false
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Remove all the characters.");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }
    // This test checks if the method removes all the characters with the same number of
    // spaces left if n is 1 and maintainSpacing is true
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("Leave all spaces.");
        assertEquals("                 ", manipulatedstring.removeNthCharacter(1, true));
    }

    // This test checks if the method throws IndexOutOfBoundsException if .removeNthCharacter()
    // is called when the string has been set to an empty string
    @Test
    public void testRemoveNthCharacter8() {
        manipulatedstring.setString("");
        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedstring.removeNthCharacter(1, true);});
    }

    // This test checks if the method removes the last character when n equals
    // the length of the string
    @Test
    public void testRemoveNthCharacter9() {
        manipulatedstring.setString("Remove the last character!");
        assertEquals("Remove the last character", manipulatedstring.removeNthCharacter(26, false));
    }
    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // This test checks if the method returns a correct substring when startWord and
    // endWord has the same integer
    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("Just one word.");
        String[] subString = manipulatedstring.getSubStrings(2,2);
        assertEquals(subString[0], "one");
    }

    // This test checks if the method throws NullPointerException when null has been set
    // to the string
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString(null);
        assertThrows(NullPointerException.class, ()->{manipulatedstring.getSubStrings(2, 4);});
    }

    // This test checks if the method throws an IllegalArgumentException when startWord is
    // zero
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This is a test.");
        assertThrows(IllegalArgumentException.class, ()->{manipulatedstring.getSubStrings(0, 3);});
    }

    // This test checks if the method throws an IllegalArgumentException when endWord is zero.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This is also a test.");
        assertThrows(IllegalArgumentException.class, ()->{manipulatedstring.getSubStrings(3, 0);});
    }

    // This test checks if the method throws an IllegalArgumentException when startWord is
    // larger than the endWord
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This is another test.");
        assertThrows(IllegalArgumentException.class, ()->{manipulatedstring.getSubStrings(2, 1);});
    }

    // This test checks if the method throws an IndexOutOfBoundsException when endWord is
    // larger than the length of the string
    @Test
    public void testGeSubStrings7() {
        manipulatedstring.setString("This is another test.");
        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedstring.getSubStrings(3, 6);});
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

    // This test checks if the IllegalArgumentException is thrown when the length of the indices[]
    // is longer than the length of the given string
    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("heart");
        int[] array = new int[]{2, 3, 4, 0, 1, 5};
        assertThrows(IllegalArgumentException.class, ()->{ manipulatedstring.restoreString(array);});
    }

    // This test checks if the IllegalArgumentException is thrown when the length of the indices[]
    // is shorter than the length of the given string
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("heart");
        int[] array = new int[]{2, 3, 4, 0};
        assertThrows(IllegalArgumentException.class, ()->{ manipulatedstring.restoreString(array);});
    }

    // This test checks if the IndexOutOfBoundsException is thrown when any indices[i] is
    // less than zero
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("team");
        int[] array = new int[]{-1, 0, 1, 2};
        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedstring.restoreString(array);});
    }

    // This test checks if the IndexOutOfBoundsException is thrown when an indices[i] is larger
    // than or the equal to the length of the string
    @Test
    public void testRestoreString5(){
        manipulatedstring.setString("group");
        int[] array = new int[]{5, 0, 1, 2, 3};

        assertThrows(IndexOutOfBoundsException.class, ()->{manipulatedstring.restoreString(array);});

    }

    // This test checks if the method throws NullPointerException if the string is null
    @Test
    public void testRestoreString6() {
        manipulatedstring.setString(null);
        int[] array = new int[]{2,3,5,4,1,0};
        assertThrows(NullPointerException.class, ()->{manipulatedstring.restoreString(array);});
    }

    // This test checks if the method returns the correct string regardless of the case
    @Test
    public void testRestoreString7() {
        manipulatedstring.setString("MASTER");
        int[] array = new int[]{2,3,5,4,1,0};
        assertEquals("STREAM", manipulatedstring.restoreString(array));
    }

    // This is an additional test to check if getString() properly returns null when
    // the manipulatedstring is null
    @Test
    public void testGetString(){
        manipulatedstring.setString(null);
        assertNull(manipulatedstring.getString());
    }


}

