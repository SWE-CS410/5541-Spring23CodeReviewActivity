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
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] subStrings = manipulatedstring.getSubStrings(3, 4);

        assertEquals("my", subStrings[0]);
        assertEquals("string", subStrings[1]);
    }

    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("This is my string");
        String[] subStrings = manipulatedstring.getSubStrings(1, 1);

        assertEquals("This", subStrings[0]);
    }

    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int[] indices = new int[]{1, 0, 2};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals("rat", restoreString);
    }

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("");
        int[] indices = new int[]{};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals("", restoreString);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("12345");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("One two three four");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("Hello, World!");
        assertEquals("Helo, Wrld!", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Hello, World!");
        assertEquals("Helo Wrld", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("This is my string");
        String[] subStrings = manipulatedstring.getSubStrings(2, 3);

        assertEquals("is", subStrings[0]);
        assertEquals("my", subStrings[1]);
    }

    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("One two three four five");
        String[] subStrings = manipulatedstring.getSubStrings(1, 5);

        assertEquals("One", subStrings[0]);
        assertEquals("two", subStrings[1]);
        assertEquals("three", subStrings[2]);
        assertEquals("four", subStrings[3]);
        assertEquals("five", subStrings[4]);
    }

    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("abc");
        int[] indices = new int[]{2, 0, 1};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals("bca", restoreString);
    }

    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("hello");
        int[] indices = new int[]{4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals("olleh", restoreString);
    }
}