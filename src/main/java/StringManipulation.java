/**
 * This class implements the StringManipulationInterface and provides
 * an implementation for manipulating strings.
 */
public class StringManipulation implements StringManipulationInterface {
    private String myString;

    /**
     * Returns the current string. If the string is null, it should return null.
     *
     * @return Current string
     */
    @Override
    public String getString() {
        if (myString != null) {
            return myString;
        } else {
            return null;
        }
    }

    /**
     * Sets the value of the current string.
     *
     * @param string The value to be set
     */
    @Override
    public void setString(String string) {
        myString = string;
    }

    /**
     * Returns the number of words in the current string.
     *
     * @return Number of words in the current string
     */
    @Override
    public int count() {
        if (myString == null) {
            return 0;
        }
        // Split the string into words using whitespace as the delimiter
        String[] words = myString.trim().split("\\s+");
        return words.length;
    }

    /**
     * Returns a string that consists of all characters in the original string
     * except for the characters
     * in positions n, 2n, 3n, and so on, either deleting those or replacing them
     * with a white space.
     * The characters in the resulting string should be in the same order and with
     * the same case as in the current string.
     *
     * @param n               Determines the positions of the characters to be
     *                        returned
     * @param maintainSpacing Determines whether to replace the missing characters
     *                        with a space
     *                        in order to maintain the length of the original string
     * @return String made of characters at positions other than n, 2n, and so on in
     *         the current string
     */
    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (myString == null || n <= 0 || n > myString.length()) {
            throw new IndexOutOfBoundsException();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < myString.length(); i++) {
            if ((i + 1) % n != 0) {
                result.append(myString.charAt(i));
            } else if (maintainSpacing) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    /**
     * Returns the words from position "startWord" to position "endWord" in the
     * sentence,
     * with 1 being the first word in the string.
     *
     * @param startWord Position of the first word to return
     * @param endWord   Position of the last word to return
     * @return String array of the words from position "startWord" to position
     *         "endWord"
     * @throws IllegalArgumentException  If either "startWord" or "endWord" are
     *                                   invalid (i.e.,
     *                                   "startWord" <= 0, "endWord" <= 0, or
     *                                   "startWord" > "endWord")
     * @throws IndexOutOfBoundsException If the string has fewer than "endWord"
     *                                   words in it
     */
    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        // Check for valid startWord and endWord values
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord values");
        }
        // Split the string into separate words
        String[] words = getString().split(" ");

        // Check if the string has enough words for the endWord position
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("The string does not have enough words");
        }

        // Calculate the number of words to extract
        int numWords = endWord - startWord + 1;

        // Create an array to store the extracted words
        String[] subStrings = new String[numWords];

        // Extract the words from the specified positions
        for (int i = 0; i < numWords; i++) {
            subStrings[i] = words[startWord - 1 + i];
        }
        return subStrings;
    }

    /**
     * Given a string s and an integer array indices of the same length,
     * shuffles the characters in the string based on the indices array.
     *
     * @param indices Integer array for shuffled string new indices positions
     *                The character at the ith position moves to indices[i] in the
     *                shuffled string
     * @return Shuffled strings
     */
    @Override
    public String restoreString(int[] indices) {
        if (myString == null || indices.length != myString.length()) {
            throw new IllegalArgumentException("Invalid length of indices array");
        }
        char[] shuffledChars = new char[indices.length];
        for(int i =0; i < indices.length; i++){
            int index = indices[i];
            if (index < 0 || index >= myString.length()){
                throw new IndexOutOfBoundsException("Invalid index value in indices array");
            }    
            shuffledChars[index] = myString.charAt(i);
        }
        return new String(shuffledChars);
    }
}
