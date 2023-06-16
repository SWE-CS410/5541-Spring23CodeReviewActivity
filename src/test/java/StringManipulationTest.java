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
    void testCount2() {
        manipulatedstring.setString("Why did the chicken go to the seance? To talk to the other side!");
        int length = manipulatedstring.count();
        assertEquals(14, length);
    }

    /**
     * This test verifies the count of words in a string containing a joke.
     * The expected count is 10, and it checks if the method correctly counts words,
     * even in a humorous context.
     */
    @Test
    void testCount3() {
        manipulatedstring.setString("Why don't scientists trust atoms? Because they make up everything!");
        int length = manipulatedstring.count();
        assertEquals(10, length, "Haha! The count of words in the string should be 9. Atoms really do make up everything, don't they?");
    }

    /**
     * This test checks the count of words in a string with a joke about anti-gravity.
     * The expected count is 11, and it adds a humorous twist to the test case.
     */
    @Test
    void testCount4() {
        manipulatedstring.setString("I'm reading a book about anti-gravity. It's impossible to put down!");
        int length = manipulatedstring.count();
        assertEquals(11, length, "math jokes can be quite uplifting!");
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
    void testRemoveNthCharacter3() {
        manipulatedstring.setString("X Games");
        String result = manipulatedstring.removeNthCharacter(2, true);
        assertEquals("X G m s", result);
    }


    /**
     * This test checks the removal of characters in a string related to basketball.
     * It tests the functionality of removing every 2nd character while maintaining spacing.
     * The expected result is "Basketball is a popular sport in 2023" with some characters replaced by spaces.
     */
    @Test
    public void testRemoveNthCharacter4() {
        manipulatedstring.setString("Basketball is a popular sport in 2023");
        String result = manipulatedstring.removeNthCharacter(2, true);
        assertEquals("B s e b l   s a p p l r s o t i   0 3", result);
    }

    /**
     * This test checks the removal of characters in a string related to football.
     * It tests the functionality of removing every 5th character while maintaining spacing.
     * The expected result is "Football is the best sport on the planet! yes I mean soccer!" with some characters replaced by spaces.
     */
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("Football is the best sport on the planet! yes I mean soccer!");
        String result = manipulatedstring.removeNthCharacter(5, true);
        assertEquals("Foot all  s th  bes  spo t on the  lane ! ye  I m an s ccer ", result);
    }

    /**
     * This test checks the removal of characters in a string related to tennis.
     * It tests the functionality of removing every 4th character while maintaining spacing.
     * The expected result is "Tennis is a racquet sport that can be played individually or in pairs 9876" with some characters replaced by spaces.
     */
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("Tennis is a racquet sport that can be played individually or in pairs 9876");
        String result = manipulatedstring.removeNthCharacter(4, true);
        assertEquals("Ten is  s a rac uet spo t t at  an  e p aye  in ivi ual y o  in pai s 9 76", result);
    }

    /**
     * This test checks the removal of characters in a string related to golf.
     * It tests the functionality of removing every 3rd character while maintaining spacing.
     * The expected result is "Golf is a precision, TIGER WOODS ROCKS" with some characters replaced by spaces.
     */
    @Test
    public void testRemoveNthCharacter7() {
        manipulatedstring.setString("Golf is a precision, TIGER WOODS ROCKS");
        String result = manipulatedstring.removeNthCharacter(3, true);
        assertEquals("Go f  s   p ec si n, TI ER WO DS RO KS", result);
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String[] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    @Test
    public void testGeSubStrings2() {
        manipulatedstring.setString("Data structures are essential for efficient algorithm design");
        String[] subStrings = manipulatedstring.getSubStrings(2, 5);

        assertEquals(subStrings[0], "structures");
        assertEquals(subStrings[1], "are");
        assertEquals(subStrings[2], "essential");
        assertEquals(subStrings[3], "for");
    }

    @Test
    public void testGeSubStrings3() {
        manipulatedstring.setString("Object-oriented programming promotes code reusability and modularity");
        String[] subStrings = manipulatedstring.getSubStrings(1, 3);

        assertEquals(subStrings[0], "Object-oriented");
        assertEquals(subStrings[1], "programming");
    }

    @Test
    public void testGeSubStrings4() {
        manipulatedstring.setString("Computer science is amazing");
        String[] subStrings = manipulatedstring.getSubStrings(2, 4);

        assertEquals(subStrings[0], "science");
        assertEquals(subStrings[1], "is");
    }


    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("Artificial intelligence is revolutionizing various industries");
        String[] subStrings = manipulatedstring.getSubStrings(1, 4);

        assertEquals(subStrings[0], "Artificial");
        assertEquals(subStrings[1], "intelligence");
        assertEquals(subStrings[2], "is");
        assertEquals(subStrings[3], "revolutionizing");
    }

    @Test
    public void testGeSubStrings6() {
        manipulatedstring.setString("Network security is crucial for protecting sensitive information");
        String[] subStrings = manipulatedstring.getSubStrings(3, 5);

        assertEquals(subStrings[0], "is");
        assertEquals(subStrings[1], "crucial");
        assertEquals(subStrings[2], "for");
    }


    @Test
    public void testRestoreString1() {
        manipulatedstring.setString("art");
        int[] array;
        array = new int[]{1, 0, 2};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "rat");
    }

    @Test
    public void testRestoreString2() {
        // This test verifies that the restoreString method correctly restores the original string "racecar"
        manipulatedstring.setString("racecar");
        int[] array = new int[]{6, 5, 4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "racecar");
    }

    @Test
    public void testRestoreString3() {
        // This test checks whether the restoreString method handles the original string "image" correctly
        manipulatedstring.setString("image");
        int[] array = new int[]{0, 1, 2, 3, 4};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "image");
    }

    @Test
    public void testRestoreString4() {
        // This test ensures that the restoreString method properly restores the palindrome "tenet"
        manipulatedstring.setString("tenet");
        int[] array = new int[]{4, 3, 2, 1, 0};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "tenet");
    }

    @Test
    public void testRestoreString9() {
        // This test validates that the restoreString method rearranges the characters correctly for the string "MRAY"
        manipulatedstring.setString("MRAY");
        int[] array = new int[]{2, 1, 0, 3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "ARMY");
    }

}

