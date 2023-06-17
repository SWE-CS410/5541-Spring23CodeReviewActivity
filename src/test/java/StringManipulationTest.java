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
        manipulatedstring.setString("Testing for string");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("Testing testing");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    @Test
    public void testCount4() {
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
        manipulatedstring.setString("Hi this is the message");
        assertEquals("H   h s i   h   e s g ", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("This message should have less character deleted");
        assertEquals("This me sage sh uld hav  less c aracter deleted", manipulatedstring.removeNthCharacter(8, true));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("This message should have only the last character deleted");
        assertEquals("This message should have only the last character delete", manipulatedstring.removeNthCharacter(56, false));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("This message should be unreadable");
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    assertEquals("", manipulatedstring.removeNthCharacter(100, false));
                }
        );
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("This message is meant to be deleted");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals("my", sStings[0]);
        assertEquals("string", sStings[1]);
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This change is requested by Caleb");


        assertThrows(
                IllegalArgumentException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(6, 1);
                }
        );
    }

    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("This is a odd string");
        String [] sStings = manipulatedstring.getSubStrings(1, 3);

        assertEquals("This", sStings[0]);
        assertEquals("a", sStings[2]);
    }

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("This string is a very long string");
        String [] sStings = manipulatedstring.getSubStrings(2, 4);

        assertEquals("string", sStings[0]);
        assertEquals("a", sStings[2]);
    }

    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("This sting will return the first and last string");
        String [] sStings = manipulatedstring.getSubStrings(1, 9);

        assertEquals("This", sStings[0]);
        assertEquals("string", sStings[8]);
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("This string is the last test string");
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(1, 100);
                }
        );
    }

    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int [] array;
        array = new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("rat", restoreString);
    }

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array = new int[]{4,5,6,7,0,1,2,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("TestUnit", restoreString);
    }

    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("eat");
        int [] array;
        array = new int[]{2,0,1};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("tea", restoreString);
    }

    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("cat");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("act", restoreString);
    }

    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("");
        int [] array;
        array=new int[]{2,1,0};
        assertThrows(
                IllegalArgumentException.class, () -> {
                    String restoreString = manipulatedstring.restoreString(array);
                }
        );
    }

}
