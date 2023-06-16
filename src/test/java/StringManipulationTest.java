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

    // Checks what happens if an empty string is passed in
    @Test
    public void testCount2() {
        manipulatedstring.setString("          ");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // This test checks that numbers are recognized as strings
    @Test
    public void testCount3() {
        manipulatedstring.setString("132 444");
        int length = manipulatedstring.count();
        assertEquals(2, length);
    }

    // This test ensures that the counter works on a long string
    @Test
    public void testCount4() {
        String phrase = "the quick brown fox jumps over the lazy dog";
        int expectedCount = 9;
    
        StringManipulation stringManipulation = new StringManipulation();
        stringManipulation.setString(phrase);
    
        int actualCount = stringManipulation.count();
    
        assertEquals(expectedCount, actualCount);
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
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(0, true));
    }
        
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("                                                 ", manipulatedstring.removeNthCharacter(1, true));
    }
    
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", manipulatedstring.removeNthCharacter(1, false));
    }
    
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.removeNthCharacter(100, false));
    }
    
    // Checks removing a negative Nth character
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertThrows(IllegalArgumentException.class, () -> manipulatedstring.removeNthCharacter(-1, false));
    }

    @Test
    public void testGetSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // START
      // Test getting substrings with a starting value less than 0
      @Test
      public void testGetSubStrings2() {
          manipulatedstring.setString("This is my string");
          // This test tries to get substrings with a negative starting value
          assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(-1, 4));
      }
      
      @Test
      public void testGetSubStrings3() {
          manipulatedstring.setString("This is my string");
          // This test tries to get substrings with the starting value greater than the ending one
          assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(2, 1));
      }
      
      @Test
      public void testGetSubStrings4() {
          manipulatedstring.setString("This is my string");
          // This test tries to get substrings with both the starting and ending value negative
          assertThrows(IllegalArgumentException.class, () -> manipulatedstring.getSubStrings(-2, -1));
      }
      
      @Test
      public void testGetSubStrings5() {
          manipulatedstring.setString("This is my string");
          assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.getSubStrings(1, 100));
      }
      
      @Test
      public void testGetSubStrings6() {
          manipulatedstring.setString("This is my string");
          String [] sStings = manipulatedstring.getSubStrings(1, 1);
  
          assertEquals(sStings.length, 1);
          assertEquals(sStings[0], "This");
      }
  
      
      
// END

    @Test
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    // Tests that case is maintained
    @Test
    public void testRestoreString2()
    {
        manipulatedstring.setString("AaBbCc");
        int [] array;
        array=new int[]{1,0,3,2,5,4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "aAbBcC");
    }
    
     
     @Test
     public void testRestoreString3() {
         manipulatedstring.setString("AaBbCc");
         int[] indices = {1};
         // Tests when the indices array size is smaller than the string length
         assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(indices));
     }
     
     @Test
     public void testRestoreString4() {
         manipulatedstring.setString("AaBbCc");
         int[] indices = {1, 2, 3, 4, 5, 6, 7};
         // Tests when the indices array size is larger than the string length
         assertThrows(IllegalArgumentException.class, () -> manipulatedstring.restoreString(indices));
     }
     
     @Test
     public void testRestoreString5() {
         manipulatedstring.setString("AaBbCc");
         int[] indices = {1, 2, 3, 4, 5, -1};
         // Tests when an index in the indices array is less than zero
         assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(indices));
     }
     
     @Test
     public void testRestoreString6() {
         manipulatedstring.setString("AaBbCc");
         int[] indices = {1, 2, 3, 4, 5, 7};
         // Tests when an index in the indices array is larger than the string length
         assertThrows(IndexOutOfBoundsException.class, () -> manipulatedstring.restoreString(indices));
     }
     
}