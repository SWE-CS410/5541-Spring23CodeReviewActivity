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

    //Many word case
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    //Empty string case
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //Null string case
    @Test
    public void testCount3() {
        manipulatedstring.setString(null); //Not really needed (because string starts null), but kept for clarity.
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //One word case
    @Test
    public void testCount4() {
        manipulatedstring.setString("Supercalifragilisticexpialidocious");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    //Only spaces case
    @Test
    public void testCount5() {
        manipulatedstring.setString("           ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //Only tab case
    @Test
    public void testCount6() {
        manipulatedstring.setString("\t\t\t");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //Only carriage return case
    @Test
    public void testCount7() {
        manipulatedstring.setString("\r");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //Only newlines case
    @Test
    public void testCount8() {
        manipulatedstring.setString("\n\n\n");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    //Multiple spaces between words case
    @Test
    public void testCount9() {
        manipulatedstring.setString("Lots          of space        between");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    //Do not maintain spacing case
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    //Maintain spacing case
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    //Throws IndexOutOfBoundsException when n larger than string length
    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("abcdef");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(7, false));
        assertEquals("Index out of bounds", e.getMessage());
    }

    //Throws IllegalArgumentException when n is negative
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("foobar");
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-2, false));
        assertEquals("N must be greater than 0", e.getMessage());
    }

    //Throws IllegalArgumentException when n is zero
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("foobar");
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, false));
        assertEquals("N must be greater than 0", e.getMessage());
    }

    //n=1, do not maintain spacing case
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("12345 6789");
        String result = manipulatedstring.removeNthCharacter(1, false);
        int length = result.length();
        assertEquals(0, length);
    }

    //n=1, maintain spacing case
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("12345 6789");
        String result = manipulatedstring.removeNthCharacter(1, true);
        int length = result.length();
        assertEquals(10, length);
    }

    //null string case
    @Test
    public void testRemoveNthCharacter8() {
        manipulatedstring.setString(null);
        String s = manipulatedstring.removeNthCharacter(3, true);
        assertNull(s);
    }

    //Average case
    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStrings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStrings[0], "my");
        assertEquals(sStrings[1], "string");
    }

    //Throws IllegalArgumentException when startword <= 0
    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("It's beginning to look a lot like Christmas");
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(-1, 3));
        assertEquals("startWord must be greater than zero", e.getMessage());
    }

    //Throws IllegalArgumentException when endword <= 0
    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("I used to wish I was, but I'm glad I'm not");
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(1, -3));
        assertEquals("endWord must be greater than zero", e.getMessage());
    }

    //Throws IllegalArgumentException when startword > endword
    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("I know the roads to riches and I know the ways to fame");
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(7, 4));
        assertEquals("startWord cannot be larger than endWord", e.getMessage());
    }

    //Throws IndexOutOfBoundsException when string.count() < endword
    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("Balloons are deflating");
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 4));
        assertEquals("endWord cannot be larger than the total word count", e.getMessage());
    }

    //null string
    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString(null);
        String[] array = manipulatedstring.getSubStrings(2, 4);
        assertNull(array);
    }

    //Average case
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    //unequal lengths case. Throws IllegalArgumentException
    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("extraordinary");
        int[] indices = {0,1,2,3,4};
        Exception e = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(indices));
        assertEquals("String length must match array length", e.getMessage());
    }

    //negative index. Throws IndexOutOfBoundsException
    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("tubular");
        int[] indices = {-1,2,3,4,5,6,7};
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(indices));
        assertEquals("Invalid array index", e.getMessage());
    }

    //index > string length. Throws IndexOutOfBoundsException
    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("radical");
        int[] indices = {1,2,3,4,5,6,10};
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(indices));
        assertEquals("Invalid array index", e.getMessage());
    }

    //null string
    @Test
    public void testRestoreString5() {
        manipulatedstring.setString(null);
        int[] indices = {1,2,3,4};
        String result = manipulatedstring.restoreString(indices);
        assertNull(result);
    }

}
