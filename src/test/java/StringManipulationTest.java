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


    // testcount1() test that it should behave as expected and print out 4 items
    @Test
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }
    // testcount()2 test if there is nothing there and should return a 1
    @Test
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // testcount()3 test to see  tab  and  new line  it should  print 0
    @Test
    public void testCount3() {
            manipulatedstring.setString("     \t      \n");
            int length = manipulatedstring.count();
            assertEquals(0, length);
    }
    // testcount()4  test to see  tab  and  new line with words it should print 4
    @Test
    public void testCount4() {
        manipulatedstring.setString("This\tthis\nmy string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }
    // test to see if funcation delete every third characters:false
    @Test
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }
    // test to see if funcation replace  every third character with spacing:true
    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }
    // test an exception of throws IndexOutOfBoundsException If n is greater than the string length with deleting n characters. IndexOutOfBoundsException If n is greater than the string length.

    @Test
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");

        assertThrows(
            IndexOutOfBoundsException.class, () -> {
                 manipulatedstring.removeNthCharacter(100, false);
            }
        );


    };



    // test an exception of throws IndexOutOfBoundsException If n is greater than the string length with  replacing every n character with spacing . IndexOutOfBoundsException If n is greater than the string length.
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");

        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    manipulatedstring.removeNthCharacter(100, true);
                }
        );

    }
    // test an exception of throws IIllegalArgumentException If n is equal to zero deleting n characters. IndexOutOfBoundsException
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");

        assertThrows(
                IllegalArgumentException.class, () -> {
                    manipulatedstring.removeNthCharacter(0, false);
                }
        );
    }


    // test an exception of throws IIllegalArgumentException If n is equal to zero  replacing every n character with spacing. IndexOutOfBoundsException
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");

        assertThrows(
                IllegalArgumentException.class, () -> {
                    manipulatedstring.removeNthCharacter(0, true);
                }
        );
    }


    //test boundry    that it would stop if n=3 and there 5 characters "hey i" should be equal to "he  i"  replacing every 3n character with spacing
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("hey i");
        assertEquals("he  i", manipulatedstring.removeNthCharacter(3, true));
    }
    //test boundry    that it would stop if n=3 and there 5 characters "hey i" should be equal to "he i"  deleting every 3n character
    @Test
    public void testRemoveNthCharacter8() {
        manipulatedstring.setString("hey i");
        assertEquals("he i", manipulatedstring.removeNthCharacter(3, false));
    }

    // tested if 1 = n and false should leave string empty
    @Test
    public void testRemoveNthCharacter9() {
        manipulatedstring.setString("hey i");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }

    // tested if 1 = n and true should leave string  5 empty spaces
    @Test
    public void testRemoveNthCharacter10() {
        manipulatedstring.setString("hey i");
        assertEquals("     ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }
    // throw the  exception of illegalArgumentException if start word is less or equal to sero
    @Test
    public void testGetSubStrings2() {
        manipulatedstring.setString("this is my string ");

        assertThrows(
                IllegalArgumentException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(0, 4);
                }
        );
    }
    // throw the  exception of illegalArgumentException if end word is less or equal to zero or less then start word
    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("this is my string ");

        assertThrows(
                IllegalArgumentException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(4, 3);
                }
        );
    }
    // throw IndexOutOfBoundsException has less then end word with it
    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("this is my string ");

        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(0, 5);
                }
        );
    }
    // testing if start word and end word is the same thing
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("fairies wear boots ");
        String [] sStings = manipulatedstring.getSubStrings(3, 3);

        assertEquals( "boots", sStings[0]);
    }
    // testing if start word and end world are greater then total words
    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("blue oyster cult");

        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    String [] sStings = manipulatedstring.getSubStrings(6, 8);
                }
        );    }

    // test funcationality
    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }
    // test  IndexOutOfBoundsException by not matchling length of string
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("art");
        int [] indices = new int[]{1,0,3};
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    String restoreString= manipulatedstring.restoreString( indices );
                }
        );

    }
    // test  illegalArgumentException by not matching  indexs of being outbounds
    @Test
    public void testRestoreString3()
    {
        manipulatedstring.setString("part");
        int [] indices = new int[]{1,0,2};
        assertThrows(
                IllegalArgumentException.class, () -> {
                    String restoreString= manipulatedstring.restoreString( indices  );
                }
        );
    }

    // how well  it handles the empty the string and empty  index
    @Test
    public void testRestoreString4()
    {
        manipulatedstring.setString("");
        int [] indices = new int[]{};
        String restoreString = manipulatedstring.restoreString(indices );
        assertEquals(restoreString, "");

    }
    // testing with special character
    @Test
    public void testRestoreString5()
    {
        manipulatedstring.setString("a@b#c$d");
        int[] indices = new int[]{6, 5, 4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(indices);
        assertEquals("d$c#b@a", restoreString);

    }

}
