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
    	manipulatedstring.setString("Thisismystring");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    public void testCount3() {
    	manipulatedstring.setString("23 and me");
        int length = manipulatedstring.count();
        assertEquals(3, length);
    }

    @Test
    public void testCount4() { 
    	manipulatedstring.setString("This is  my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);   
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
        String temp =  manipulatedstring.removeNthCharacter(3, false);
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", temp);
    }

    @Test
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        String temp =  manipulatedstring.removeNthCharacter(3, true);
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", temp);
    }

    @Test
    public void testRemoveNthCharacter3() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	String temp = manipulatedstring.removeNthCharacter(5, false);    
    	
    	assertEquals("I'd 3tt3 puts0med161s inthis5tr16, rght?", temp);
    }

    @Test
    public void testRemoveNthCharacter4() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'd  3tt3  put s0me d161 s in this 5tr1 6, r ght?", manipulatedstring.removeNthCharacter(5, true));    
    }

    @Test
    public void testRemoveNthCharacter5() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(100, false));
        assertEquals("'n' is greater than the string length.", exception.getMessage());  
    }

    @Test
    public void testRemoveNthCharacter6() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, false));
        assertEquals("'n' must be greater than zero.", exception.getMessage());
    }
    
    @Test
    public void testRemoveNthCharacter7() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1, false));
        assertEquals("'n' must be greater than zero.", exception.getMessage());
    }

    @Test
    public void testRemoveNthCharacter8() {
    	manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'd b3tt3r put s0me d161ts in this 5tr1n6, right", manipulatedstring.removeNthCharacter(49, false));    
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGetSubStrings2() {
    	 manipulatedstring.setString("Thisismystring");
         Throwable exception = assertThrows(Exception.class, () -> manipulatedstring.getSubStrings(3, 4));
         assertEquals("The String has less than 4 words", exception.getMessage());
    }
    @Test
    public void testGetSubStrings3() {
    	 manipulatedstring.setString("");
         Throwable exception = assertThrows(Exception.class, () -> manipulatedstring.getSubStrings(1, 4));
         assertEquals("The String has less than 4 words", exception.getMessage());
    }
    @Test
    public void testGetSubStrings4() {
    	 manipulatedstring.setString("This is my string");
         String [] sStings = manipulatedstring.getSubStrings(3, 3);

         assertEquals(sStings[0], "my");
    }
    @Test
    public void testGetSubStrings5() {
    	manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(5, 1));
        assertEquals("Invalid startWord or endWord", exception.getMessage());
    }
    @Test
    public void testGetSubStrings6() {
    	manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 100));
        assertEquals("The String has less than 100 words", exception.getMessage());
    }
    
    @Test
    public void testGetSubStrings7() {
    	manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(-1, 3));
        assertEquals("Invalid startWord or endWord", exception.getMessage());
    }
    
    @Test
    public void testGetSubStrings8() {
    	manipulatedstring.setString("This is my string");
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(1, -3));
        assertEquals("Invalid startWord or endWord", exception.getMessage());
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
    	manipulatedstring.setString("This is my string");
    	
        int [] array;
        array=new int[]{1,0,2,5,3,4,7,6};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(array) );
        assertEquals("The indices array must be the same length as the string.", exception.getMessage());
    }

    @Test
    public void testRestoreString3()
    {
    	manipulatedstring.setString("This is my string");
    	int [] array;
        array=new int[]{-1,0,2,5,3,4,7,6,13,15,16,9,10,12,8,14,11};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array) );
        assertEquals("All values in the indices array must correspond to valid indexes in the string.", exception.getMessage());
    }

    @Test
    public void testRestoreString4()
    {
    	manipulatedstring.setString("This is my string");
    	int [] array;
        array=new int[]{1,0,2,5,3,4,7,6,13,15,16,9,10,12,8,100,11};
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(array) );
        assertEquals("All values in the indices array must correspond to valid indexes in the string.", exception.getMessage());


    }

    @Test
    public void testRestoreString5()
    {
    	manipulatedstring.setString("second test ");
        int [] array;
        array=new int[]{11,10,9,8,7,6,5,4,3,2,1,0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, " tset dnoces");

    }

}
