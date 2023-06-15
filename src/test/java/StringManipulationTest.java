import org.junit.jupiter.api.*;
import static org.junit.Assert.assertThrows;
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

    // This test checks if an empty string will have a word count of 0.
    // The method should return a count of 0 for a string with 0 words.
    @Test
    public void testCount2() {
    	manipulatedstring.setString("");
        int length = manipulatedstring.count();
        assertEquals(0, length);
    }

    // This test checks whether the method will return 5 for a string with 5 words
    // despite a series of spaces at the end of the string. The method should disregard 
    // all the spaces in string when counting the number of words.
    @Test
    public void testCount3() {
    	manipulatedstring.setString("this sentence has 5 words. ");
        int length = manipulatedstring.count();
        assertEquals(5, length);
    }

    // This test checks whether the method will return 3 for a string with 3 words
    // despite the string having a series of spaces in between words. The method should
    // disregard the number of spaces between words even if they are more than one space.
    @Test
    public void testCount4() {
    	manipulatedstring.setString("1  2  3 ");
        int length = manipulatedstring.count();
        assertEquals(3, length);
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

    // This will test whether the method will correctly remove the characters
    // in a string with 12 characters by a factor of 2. With a factor of 2 and a
    // string of length 12, the characters at position 2,4,6,8,10,12 will be removed
    // and since the maintainSpacing parameter is false, then the characters at those
    // positions will be deleted.
    @Test
    public void testRemoveNthCharacter3() {
    	manipulatedstring.setString("hello world!");
    	assertEquals("hlowrd", manipulatedstring.removeNthCharacter(2, false));
    }
    
    // This will test whether the method will correctly remove the characters
    // in a string with 12 characters by a factor of 3. With a factor of 3 and a
    // string of length 12, the characters at position 3,6,9,12 will be removed
    // and since the maintainSpacing parameter is true, then the characters at those
    // positions will be replaced with a space character.
    //
    // The character in the last position will be replaced with a space which will 
    // maintain the original string length of 12
    @Test
    public void testRemoveNthCharacter4() {
    	manipulatedstring.setString("hello world!");
    	assertEquals("he lo wo ld ", manipulatedstring.removeNthCharacter(3, true));
    }

    // This will test the maintainSpacing of the method. The given string has a total of 5 
    // spaces that are originally in the string. With false passed in for maintainSpacing,
    // the output string should retain the 5 spaces and remove the characters at positions 3n.
    @Test
    public void testRemoveNthCharacter5() {
        manipulatedstring.setString("0 3  6  9");
        assertEquals("0     ", manipulatedstring.removeNthCharacter(3, false));
    }
    
    // This will test that the method will throw an IndexOutOfBoundsException()
    // if n is greater than the string length, it is not possible to remove characters
    // by a factor that is greater than the length of the string.
    //
    // In this test case, the string has a total of 19 characters, and the nth parameter
    // that is passed in is 20, therefore, there is no 20th character to remove, and
    // the method will catch this 20th index as out of bounds for the string.
    @Test
    public void testRemoveNthCharacter6() {
        manipulatedstring.setString("index out of bounds");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
        	manipulatedstring.removeNthCharacter(20, true);
        });
    }

    // This will test that the method will throw an IllegalArgumentException()
    // if n <= 0 then that is not a valid factor to remove characters by.
    
    // In this test case, the string has a total of 26 characters, and the nth parameter
    // that is passed in is 0, therefore, the parameter is invalid because 0n is always 0, 
    // which is not a valid factor, as the method calls for the first index position
    // of the string as position 1. The method will catch this and throw an error.
    @Test
    public void testRemoveNthCharacter7() {
    	manipulatedstring.setString("illegal argument exception");
        
        assertThrows(IllegalArgumentException.class, () -> {
        	manipulatedstring.removeNthCharacter(0, false);
        });
    }

    @Test
    public void testGeSubStrings1() {
        manipulatedstring.setString("This is my string");
        String [] sStings = manipulatedstring.getSubStrings(3, 4);

        assertEquals(sStings[0], "my");
        assertEquals(sStings[1], "string");
    }

    // This test will grab the second through the fifth word in the string,
    // despite the series of spaces in between the words. The number of spaces in
    // between words should not affect the method.
    @Test
    public void testGeSubStrings2() {
    	manipulatedstring.setString("test    string  that    has   many        spaces");
        String [] sStings = manipulatedstring.getSubStrings(2, 5);

        assertEquals(sStings[0], "string");
        assertEquals(sStings[1], "that");
        assertEquals(sStings[2], "has");
        assertEquals(sStings[3], "many");
    }
    
    // This test will test grab only the first word in the string, by taking
    // the startWord as the first word and taking the endWord as the last word.
    // The method should allow only one word to be plucked from the string by
    // taking both the startWord and endWord parameter as the same number.
    // This test also checks whether the series of spaces in between the two words
    // will affect the output. A series of spaces between words should not have an affect.
    @Test
    public void testGeSubStrings3() {
    	manipulatedstring.setString("test      string");
        String [] sStings = manipulatedstring.getSubStrings(1, 1);

        assertEquals(sStings[0], "test");
    }
    
    // This test will grab only the last word in the string of many words, all with
    // a series of spaces in between the words. The startWord and endWord parameters
    // are the same number which is the number for the last word in the string.
    @Test
    public void testGeSubStrings4() {
    	manipulatedstring.setString("another         test of    this     method");
        String [] sStings = manipulatedstring.getSubStrings(5, 5);

        assertEquals(sStings[0], "method");
    }
    
    // This will test the method if it correctly returns an IllegalArgumentException().
    // If the startWord parameter is <= 0 or if startWord > endWord,
    // then the method will through an IllegalArgumentException. This test will catch
    // both of these illegal cases and throw the appropriate exception.
    @Test
    public void testGeSubStrings5() {
        manipulatedstring.setString("illegal argument exception");
        
        assertThrows(IllegalArgumentException.class, () -> {
        	manipulatedstring.getSubStrings(0, -5);
        });
    }
    
    // This will test the method if it correctly returns an IndexOutOfBoundsException().
    // If the parameter passed in for endWord is greater than the count of words in the 
    // string then the method should throw an IndexOutOfBounds exception. In this 
    // test, the endWord is 6 for only a string with a word count of 5, throwing an error.
    @Test
    public void testGeSubStrings6() {
    	manipulatedstring.setString("index out of bounds exception");
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
        	manipulatedstring.getSubStrings(2, 6);
        });
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

    // This will test the method if it will swap the two words in the string.
    // With the space seperating the word staying in it's place, the test
    // will take each character from each side of the space and swap then for the 
    // character on the other side of the space and output a swapped string of two words.
    @Test
    public void testRestoreString2()
    {
    	manipulatedstring.setString("four five");
        int [] array;
        array=new int[]{5,6,7,8,4,0,1,2,3};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "five four");

    }

    // This will test the method to move all spaces in between the characters into 
    // one large space after the first character. 
    @Test
    public void testRestoreString3()
    {
    	manipulatedstring.setString("a b c d e f g");
        int [] array;
        array=new int[]{0,1,7,2,8,3,9,4,10,5,11,6,12};
        String restoreString = manipulatedstring.restoreString(array);
        assertEquals(restoreString, "a      bcdefg");

    }

    // This will test if the method will throw an IllegalArgumentException().
    // The method should accept an int array of equal size to the string that is 
    // being manipulated. In this test case, the string has 24 characters, and the
    // int array that is passed in only has 6 elements. Therefore, this is an invalid
    // size of int array, throwing an illegal argument exception.
    @Test
    public void testRestoreString4()
    {
    	manipulatedstring.setString("illegalargumentexception");
        int [] array;
        array=new int[]{5,4,3,2,1,0};
        
        assertThrows(IllegalArgumentException.class, () -> {
        	manipulatedstring.restoreString(array);
        });
    }

    // This will test if the method will throw an IndexOutOfBoundsException().
    // The method should accept an int array that is comprised of elements that 
    // correspond to the elements of characters in the string. If any of the elements
    // in the int array is less than 0 or greater than or equal to the string length, 
    // then that is an invalid element number for a string. In this test case,
    // -1 and 5 are elements in the int array. There is no -1 character element in any 
    // string and there is no character element of 5 for the given string which has
    // character elements 0 through 4. These parameters will throw an exception.
    @Test
    public void testRestoreString5()
    {
    	manipulatedstring.setString("ioobe");
        int [] array;
        array=new int[]{0,-1,2,5,4};
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
        	manipulatedstring.restoreString(array);
        });
    }
}

