import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class StringManipulationTest {

    private StringManipulation manipulatedstring;

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
        manipulatedstring.setString("This is another string");
        int count = manipulatedstring.count();
        assertEquals(4, count);
    }


    @Test
    public void testCount3() {
        manipulatedstring.setString("Count multiple words");
        int count = manipulatedstring.count();
        assertEquals(3, count);
    }


    @Test
    public void testCount4() {
        manipulatedstring.setString("");
        int count = manipulatedstring.count();
        assertEquals(0, count);
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
        manipulatedstring.setString("Hello, World!");
        String result = manipulatedstring.removeNthCharacter(2, false);
        assertEquals("Hlo ol!", result);
    }


    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Hello, World!");
        String result = manipulatedstring.removeNthCharacter(5, true);
        assertEquals("Hell , Wo ld!", result);
    }


    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Hello, World!");
        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(0, false);
        });
    }



    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Hello, World!");
        String result = manipulatedstring.removeNthCharacter(3, false);
        assertEquals("Helo Wrl!", result);
    }


    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("world");
        String result = manipulatedstring.removeNthCharacter(2, true);
        assertEquals("w r d", result);
    }


    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] substrings = manipulatedstring.getSubStrings(3, 4);
        assertEquals("my", substrings[0]);
        assertEquals("string", substrings[1]);
    }

    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("This is a test string");
        String[] result = manipulatedstring.getSubStrings(2, 4);
        assertArrayEquals(new String[]{"is", "a", "test"}, result);
    }


    @Test
    public void testGetSubStrings3() {
        manipulatedstring.setString("Hello, World!");
        String[] result = manipulatedstring.getSubStrings(1, 2);
        assertArrayEquals(new String[]{"Hello,", "World!"}, result);
    }


    @Test
    public void testGetSubStrings4() {
        manipulatedstring.setString("mochi is the best dog");
        String[] result = manipulatedstring.getSubStrings(2, 4);
        assertArrayEquals(new String[]{"is", "the", "best"}, result);
    }




    @Test
    public void testGetSubStrings5() {
        manipulatedstring.setString("This is a test");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(4, 6);
        });
    }



    @Test
    public void testGetSubStrings6() {
        manipulatedstring.setString("This is a test");
        String[] result = manipulatedstring.getSubStrings(1, 3);
        assertArrayEquals(new String[]{"This", "is", "a"}, result);
    }


    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int[] array = {1, 0, 2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("rat", restoreString);
    }

    @Test
    public void testRestoreString2() {
        manipulatedstring.setString("opna");
        int[] array = {3, 0, 2, 1};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("pano", restoreString);
    }


    @Test
    public void testRestoreString3() {
        manipulatedstring.setString("abcdefg");
        int[] array = {6, 5, 4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("gfedcba", restoreString);
    }


    @Test
    public void testRestoreString4() {
        manipulatedstring.setString("Hello");
        int[] array = {0, 1, 2, 3, 4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("Hello", restoreString);
    }


    @Test
    public void testRestoreString5() {
        manipulatedstring.setString("abc");
        int[] array = {1, 2, 0}; 
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("cab", restoreString);
    }


}
