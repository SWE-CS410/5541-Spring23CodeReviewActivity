
import org.junit.*;

//import org.junit.Assert.assertEquals;

public class StringManipulationTest {

    private StringManipulationInterface manipulatedstring;

    @Before
    public void setUp() {
        manipulatedstring = new StringManipulation();
    }

    @After
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
        // test checks for leading whitespace being ignored
        manipulatedstring.setString("   this is string");
        int num = manipulatedstring.count();
        assertEquals(3, num);
    }

    @Test
    public void testCount3() {
        // test checks for a single word in string
        manipulatedstring.setString("string");
        int num = manipulatedstring.count();
        assertEquals(1, num);
    }

    @org.junit.Test
    public void testCount4() {
        // test checks for a string that ends in whitespace
        manipulatedstring.setString("a string ");
        int num = manipulatedstring.count();
        assertEquals(2, num);        
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
        // test removes only last character
        manipulatedstring.setString("last.");
        assertEquals("last",manipulatedstring.removeNthCharacter(5, false));
    }

    @Test
    public void testRemoveNthCharacter4() {
        // tests for no whitepace while maintiaining spacing
        manipulatedstring.setString("maintainspacing");
        assertEquals("ma nt in pa in ", manipulatedstring.removeNthCharacter(3,true));
    }

    @Test
    public void testRemoveNthCharacter5() {
        // test removes every character without spacing
        manipulatedstring.setString("test remove every character(1) without spacing");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }   

    @Test
    public void testRemoveNthCharacter6() {
        //remove each char but keep spacing
        manipulatedstring.setString("string");
        assertEquals("      ", manipulatedstring.removeNthCharacter(1,true));
    }

    @Test
    public void testRemoveNthCharacter7() {
        // test n > 9
        manipulatedstring.setString("one last test for anyone");
        assertEquals("one last est for ayone", manipulatedstring.removeNthCharacter(10, false));
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
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);
        assertEquals(sStings[0], "This");
        assertEquals(sStings[3], "string");
    }

    @Test
    public void testGeSubStrings3() {
        // test for ignoring leading whitespace
        manipulatedstring.setString("          This is my string");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);
        assertEquals(sStings[0], "This");
        assertEquals(sStings[3], "string");
    }
    @Test
    public void testGeSubStrings4() {
        // test for ignoring whitespace in string
        manipulatedstring.setString("This     is my       string");
        String [] sStings = manipulatedstring.getSubStrings(1, 4);  
        assertEquals(sStings[0], "This");
        assertEquals(sStings[3], "string");  
    }
    @Test
    public void testGeSubStrings5() {
        // test for correctly retrieving one substring in one word
        manipulatedstring.setString("onlyoneword");
        String [] sStings = manipulatedstring.getSubStrings(1,1);
        assertEquals("onlyoneword", sStings[0]);
    }
    @Test
    public void testGeSubStrings6() {
        // test for correctly retrieving one substring in multiple word string
        manipulatedstring.setString("only one substring");
        String [] sStings = manipulatedstring.getSubStrings(1,1);    
        assertEquals("only", sStings[0]);
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
        // test swapping end and beginning chars
        manipulatedstring.setString("foot");
        int [] array;
        array=new int[]{3,1,2,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "toof");
    }

    @Test
    public void testRestoreString3()
    {
        // test reversing order
        manipulatedstring.setString("racecar");
        int [] array;
        array=new int[]{6,5,4,3,2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "racecar");
    }

    @Test
    public void testRestoreString4()
    {
        // test single char word
        manipulatedstring.setString("a");
        int [] array;
        array=new int[]{0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString,"a");
    }

    @Test
    public void testRestoreString5()
    {
        // test empty string
        manipulatedstring.setString("");
        int [] array;
        array=new int[]{};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString,"");
    }

}
