

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
    // Checks behavior for a string
    public void testCount1() {
        manipulatedstring.setString("This is my string");
        int length = manipulatedstring.count();
        assertEquals(4, length);
    }

    @Test
    // Checks behavior for 1 word string
    public void testCount2() {
        manipulatedstring.setString("string");
        int length = manipulatedstring.count();
        assertEquals(1, length);
    }

    @Test
    // Checks behavior for empty string
    public void testCount3() {
        manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    @Test
    // Checks behavior for uninitialized string
    public void testCount4() {
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.count();
            }
        };
        NullPointerException exception = assertThrows(NullPointerException.class, executable);
        assertEquals("Cannot count uninitialized string.", exception.getMessage());
    }

    @Test
    // Checks behavior for not preserving whitespace
    public void testRemoveNthCharacter1() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I' bttr uts0e 16tsinths trn6 rgh?", manipulatedstring.removeNthCharacter(3, false));
    }

    @Test
    // Checks behavior for preserving whitespace
    public void testRemoveNthCharacter2() {
        manipulatedstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("I'  b tt r  ut s0 e  16 ts in th s  tr n6  r gh ?", manipulatedstring.removeNthCharacter(3, true));
    }

    @Test
    // Checks behavior for preserving white space with n = 1 (all characters removed)
    public void testRemoveNthCharacter3() {
        manipulatedstring.setString("I <3 strings");
        assertEquals("            ", manipulatedstring.removeNthCharacter(1, true));
    }

    @Test
    // Checks behavior for not preserving white space with n = 1 (all characters removed)
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("I <3 strings");
        assertEquals(null, manipulatedstring.removeNthCharacter(1, false));
    }

    @Test
    // Checks behavior for removing interval of characters greater than string length
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("I <3 strings");
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.removeNthCharacter(20, false);
            }
        };
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, executable);
        assertEquals("n cannot be greater than the length of the string", exception.getMessage());
    }

    @Test
    // Checks behavior for removing interval of characters <0
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("I <3 strings");
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.removeNthCharacter(-1, false);
            }
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("n must be greater than 0", exception.getMessage());
    }

    @Test
    // Checks behavior for removing characters near end of string
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("I <3 strings");
        assertEquals("I <3 string ", manipulatedstring.removeNthCharacter(12, true));
    }

    @Test
    // Checks behavior for substrings
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    // Checks behavior for start or end word = 0
    public void testGeSubStrings2() {
        manipulatedstring.setString("I <3 strings");
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.getSubStrings(0, 0);
            }
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("startWord must be greater than endWord. Both startWord and endWord must be greater than 0.", exception.getMessage());
    }
    @Test
    // Checks behavior for start word > end word
    public void testGeSubStrings3() {
        manipulatedstring.setString("I <3 strings");
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.getSubStrings(3, 2);
            }
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("startWord must be greater than endWord. Both startWord and endWord must be greater than 0.", exception.getMessage());
    }
    @Test
    // Checks behavior for end word > than string length
    public void testGeSubStrings4() {
        manipulatedstring.setString("I <3 strings");
        Executable executable = new Executable() {
            public void execute() {
                manipulatedstring.getSubStrings(1, 5);
            }
        };
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, executable);
        assertEquals("endWord cannot be greater than length of substr", exception.getMessage());
    }
    @Test
    // Checks behavior for start word and end word being equal
    public void testGeSubStrings5() {
        manipulatedstring.setString("I <3 strings");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "I");
    }
    @Test
    // Extra test?
    public void testGeSubStrings6() {
        manipulatedstring.setString("I am not sure why there is a 6th test here");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "I");
    }

    @Test
    // Checks behavior for restoring string
    public void testRestoreString1()
    {
        manipulatedstring.setString("art");
        int [] array;
        array=new int[]{1,0,2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    // Checks behavior for 1 index out of bounds in indices array
    public void testRestoreString2()
    {
        manipulatedstring.setString("art");
        Executable executable = new Executable() {
            public void execute() {
                int [] array = new int[]{1,0,10};
                manipulatedstring.restoreString(array);
            }
        };
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, executable);
        assertEquals("indices must be within length of the string", exception.getMessage());
    }

    @Test
    // Checks behavior for too many indices given 
    public void testRestoreString3()
    {
        manipulatedstring.setString("art");
        Executable executable = new Executable() {
            public void execute() {
                int [] array = new int[]{0,1,2,3};
                manipulatedstring.restoreString(array);
            }
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("the number of indices provides must match positions in the string", exception.getMessage());
    }

    @Test
    // Checks behavior for non-unique indices
    public void testRestoreString4()
    {
        manipulatedstring.setString("art");
        Executable executable = new Executable() {
            public void execute() {
                int [] array = new int[]{2,2,2,};
                manipulatedstring.restoreString(array);
            }
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("incorrect indexes provided", exception.getMessage());
    }

    @Test
    // additional test ?
    public void testRestoreString5()
    {
        manipulatedstring.setString("UnitTest");
        int [] array;
        array=new int[]{4,5,6,7,0,1,2,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "TestUnit");
    }

}
