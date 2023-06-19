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
        manipulatedstring.setString("One more string for testing");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

    @Test
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    public void testCount4() {
        manipulatedstring.setString("SingleWord");
        int length = manipulatedstring.count();
        assertEquals(1, length);
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
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("111111111");
        assertEquals("1 1 1 1 1", manipulatedstring.removeNthCharacter(2, true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("111111111");
        assertEquals("11111", manipulatedstring.removeNthCharacter(2, false));
    }

    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("1");
        assertEquals("1", manipulatedstring.removeNthCharacter(4, true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("123");
        assertEquals("12", manipulatedstring.removeNthCharacter(3, false));
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
        manipulatedstring.setString("One more test string for testing");
        String [] sStings = manipulatedstring.getSubStrings(2, 3);
        assertEquals(sStings[0], "test");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("One more test string for testing");
        String [] sStings = manipulatedstring.getSubStrings(0, 4);
        assertEquals(sStings[0], "One");
        assertEquals(sStings[1], "more");
        assertEquals(sStings[2], "test");
        assertEquals(sStings[3], "string");
    }

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Only one word");
        String [] sStings = manipulatedstring.getSubStrings(0, 1);
        assertEquals(sStings[0], "Only");
    }

    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("Two words only");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);
        assertEquals(sStings[0], "words");
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("Three words here");
        String [] sStings = manipulatedstring.getSubStrings(0, 3);
        assertEquals(sStings[0], "Three");
        assertEquals(sStings[1], "words");
        assertEquals(sStings[2], "here");
    }

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("abc");
        int [] array = {2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("cba", restoreString);
    }

    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("abcdef");
        int [] array = {5,4,3,2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("fedcba", restoreString);
    }

    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("");
        int [] array = {};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("", restoreString);
    }

    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("a");
        int [] array = {0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("a", restoreString);
    }

    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("aaabaaa");
        int [] array = {6,5,4,3,2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals("aaabaaa", restoreString);
    }
}
