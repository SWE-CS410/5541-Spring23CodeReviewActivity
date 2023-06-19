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
        manipulatedstring.setString("Lets see if this works");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("Hello World Goodbye World");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("  Spaces  ");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }
    @Test
    public void testCount5() {
        manipulatedstring.setString("");
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
        manipulatedstring.setString("Bring");
        assertEquals("Bri", manipulatedstring.removeNthCharacter(5, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Spaces");
        assertEquals("Spc", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Test");
        assertEquals("    ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("!@#$%^&*()");
        assertEquals("!#%&", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("1234567890");
        assertEquals("1357", manipulatedstring.removeNthCharacter(2, false));
    }
    @Test
    public void testRemoveNthCharacterInvalidN() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(0, true);
        });
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
        manipulatedstring.setString("Lets see if this works");
        String[] subStrings = manipulatedstring.getSubStrings(4, 5);

        assertEquals("this", subStrings[0]);
        assertEquals("works", subStrings[1]);
    }

    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Hello World");
        String[] subStrings = manipulatedstring.getSubStrings(1, 2);

        assertEquals("Hello", subStrings[0]);
        assertEquals("World", subStrings[1]);
    }
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Try this out");
        String[] subStrings = manipulatedstring.getSubStrings(1, 2);

        assertEquals("Try", subStrings[0]);
        assertEquals("this", subStrings[1]);
    }

    @Test
    public void testGetSubStringsInvalidStartWord() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(0, 4);
        });
    }
    @Test
    public void testGetSubStringsInvalidEndWord() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(2, 0);
        });
    }

    @Test
    public void testGetSubStringsStartGreaterThanEnd() {
        manipulatedstring.setString("This is my string");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(3, 2);
        });
    }

    @Test
    public void testGetSubStringsEndWordOutOfBounds() {
        manipulatedstring.setString("This is my string");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(1, 5);
        });
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
        manipulatedstring.setString("");
        int[] array = {};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("", restoreString);
    }

    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("abcd");
        int[] array = {3, 1, 2, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("dbca", restoreString);
    }

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("xyz");
        int[] array = {1, 2, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("zxy", restoreString);
    }

    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("openai");
        int[] array = {0, 1, 2, 3, 4, 5};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("openai", restoreString);
    }

    @Test
    public void testRestoreStringInvalidIndicesLength() {
        manipulatedstring.setString("UnitTest");
        int[] indices = {1, 2, 3, 4}; // Invalid indices length
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }
    @Test
    public void testRestoreStringInvalidIndex() {
        manipulatedstring.setString("UnitTest");
        int[] indices = {1, 3, 6, 8, 0, 2, 5, 7}; // Invalid index value 8
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(indices);
        });
    }


}
