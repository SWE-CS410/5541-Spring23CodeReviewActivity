/*
Aravind Sripada
CS410 - Sara Farag
6/13/2023
This file contains the unit tests to ensure that the StringManipulation class works as intended.
*/

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
    //this test check for correct output
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    //this test check for correct output
    public void testCount2() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //this test check for correct output
    public void testCount3() {
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    //this test check for correct output
    public void testCount4() {
        manipulatedstring.setString("hunkady hunkad hunka hunk hun hu h");
        int length = manipulatedstring.count();
        assertEquals(7, length);
    }

    @Test
    //this test check for correct output
    public void testRemoveNthCharacter1() throws Exception {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    //this test check for correct output
    public void testRemoveNthCharacter2() throws Exception {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    //this test check for correct output by leaving the string with its default value
    public void testRemoveNthCharacter3() throws Exception {
        assertEquals(null, manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    //this test check for correct output by giving the string an empty string value
    public void testRemoveNthCharacter4() throws Exception {
        manipulatedstring.setString("");
        assertEquals("", manipulatedstring.removeNthCharacter(4, true));
    }

    @Test
    //this test checks to see if the IllegalArgumentException is thrown
    public void testRemoveNthCharacter5() throws Exception {
        manipulatedstring.setString("Hi Sara!");

        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.removeNthCharacter(-1, true);
        });
    }

    @Test
    //this class checks to see if the IndexOutOfBoundsException is thrown
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Hi Sara!");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.removeNthCharacter(100, true);
        });
    }

    @Test
    //this test check for correct output
    public void testRemoveNthCharacter7() throws Exception {
        manipulatedstring.setString("CS4420");
        assertEquals("CS420", manipulatedstring.removeNthCharacter(4, false));
    }

    @Test
    //this test check for correct output
    public void testGetSubStrings1() throws Exception {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    //this test check for correct output
    public void testGetSubStrings2() throws Exception{
        manipulatedstring.setString("I need some sleep");
        String [] sStings = manipulatedstring.getSubStrings(1, 3);

        assertEquals(sStings[0], "I");
        assertEquals(sStings[1], "need");
        assertEquals(sStings[2], "some");
    }

    @Test
    //this test checks to see if the IllegalArgumentException is thrown
    public void testGetSubStrings3() throws Exception{
        manipulatedstring.setString("I need some sleep");

        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(1, 0);
        });
    }

    @Test
    //this test checks to see if the IllegalArgumentException is thrown
    public void testGetSubStrings4() throws Exception{
        manipulatedstring.setString("I need some sleep");

        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.getSubStrings(0, 1);
        });
    }

    @Test
    //this test checks to see if the IndexOutOfBoundsException is thrown
    public void testGetSubStrings5() throws Exception {
        manipulatedstring.setString("I need some sleep");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(5, 3);
        });
    }

    @Test
    //this test checks to see if the IndexOutOfBoundsException is thrown
    public void testGetSubStrings6() throws Exception{
        manipulatedstring.setString("I need some sleep");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.getSubStrings(3, 5);
        });
    }

    @Test
    //this test check for correct output
    public void testRestoreString1() throws Exception {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    //this test check to see if the IndexOutOfBoundsException is thrown
    public void testRestoreString2() throws Exception {
        manipulatedstring.setString("acro");
        int[] array;
        array = new int[] {3, 2, -1, 0};

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    @Test
    //this test check to see if the IndexOutOfBoundsException is thrown
    public void testRestoreString3()
    {
        manipulatedstring.setString("acro");
        int[] array;
        array = new int[] {3, 2, 1, 4};

        assertThrows(IndexOutOfBoundsException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    @Test
    //this test check to see if the IllegalArgumentException is thrown
    public void testRestoreString4()
    {
        manipulatedstring.setString("acro");
        int[] array;
        array = new int[] {3, 2, 1};

        assertThrows(IllegalArgumentException.class, () -> {
            manipulatedstring.restoreString(array);
        });
    }

    @Test
    //this test check for correct output
    public void testRestoreString5() throws Exception {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "TestUnit");
    }

}
