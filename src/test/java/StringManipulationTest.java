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
        manipulatedstring.getString();
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    public void testCount2() {
        manipulatedstring.setString("I should have do the homework earlier");
        manipulatedstring.getString();
        int length = manipulatedstring.count();
        assertEquals(7, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        manipulatedstring.getString();
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("Ishouldnotleave");
        manipulatedstring.getString();
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        manipulatedstring.getString();
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        manipulatedstring.getString();
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("one two three four five");
        manipulatedstring.getString();
        assertEquals("oetotrefu ie", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("one two three four five");
        manipulatedstring.getString();
        assertEquals("o e t o t r e f u   i e", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Let test some nothing cases");
        manipulatedstring.getString();
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Let's do this together");
        manipulatedstring.getString();
        assertEquals("Let'  do  his  oget er", manipulatedstring.removeNthCharacter(5, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("let test in the middle");
        manipulatedstring.getString();
        assertEquals("let tes  in the mid le", manipulatedstring.removeNthCharacter(4, true));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        manipulatedstring.getString();
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("This is my string");
        manipulatedstring.getString();
        String [] sStings = manipulatedstring.getSubStrings(1, 2);

        assertEquals(sStings[0], "This");
        assertEquals(sStings[1], "is");
    }
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Don't try");
        manipulatedstring.getString();
        String[] subStrings = manipulatedstring.getSubStrings(1, 2);

        assertEquals(subStrings[0], "Don't");
        assertEquals(subStrings[1], "try");
    }
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Making this string long in purpose");
        manipulatedstring.getString();
        String[] subStrings = manipulatedstring.getSubStrings(3, 6);

        assertEquals(subStrings[0], "string");
        assertEquals(subStrings[1], "long");
        assertEquals(subStrings[2], "in");
        assertEquals(subStrings[3], "purpose");

    }
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("let make a substring at test 5");
        manipulatedstring.getString();

        String [] subString = manipulatedstring.getSubStrings(2, 3);
        assertEquals(subString[0], "make");
        assertEquals(subString[1], "a");
    }
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("let have three word in the substring");
        manipulatedstring.getString();

        String [] subString = manipulatedstring.getSubStrings(3, 5);
        assertEquals(subString[0], "three");
        assertEquals(subString[1], "word");
        assertEquals(subString[2], "in");
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        manipulatedstring.getString();
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("UnitTest");
        manipulatedstring.getString();
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("TestUnit", restoreString);

    }

    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("Hello");
        manipulatedstring.getString();
        int[] array = {4, 0, 1, 2, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("elloH", restoreString);

    }

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("World");
        manipulatedstring.getString();
        int[] array = {0, 1, 2, 3, 4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("World", restoreString);
    }

    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("Monica");
        manipulatedstring.getString();
        int[] array = {1, 0, 3, 2, 5, 4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("oMinac", restoreString);

    }

}
