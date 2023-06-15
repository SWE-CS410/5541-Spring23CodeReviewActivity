public class StringManipulation implements StringManipulationInterface {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    /**
     * Counts the number of non-empty words in the string.
     * @return The count of words.
     */
    public int count() {
        String[] words = string.split(" ");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    /**
     * Removes the character at the nth position in the string.
     * @param n The position of the character to be removed.
     * @param maintainSpacing Determines whether to maintain spacing when removing characters.
     * @return The string with the nth characters removed.
     */
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        validateCharacterIndex(n);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if ((i + 1) % n == 0) {
                if (maintainSpacing) {
                    stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Retrieves a substring of words from the specified startWord to the endWord.
     * @param startWord The starting index of the substring.
     * @param endWord The ending index of the substring.
     * @return An array of substrings.
     */
    public String[] getSubStrings(int startWord, int endWord) {
        validateWordIndices(startWord, endWord);

        String[] words = string.split(" ");
        String[] substrings = new String[endWord - startWord + 1];
        int wordCount = 1;
        int substringsIndex = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                if (wordCount >= startWord && wordCount <= endWord) {
                    substrings[substringsIndex] = word;
                    substringsIndex++;
                }
                wordCount++;
            }
        }

        return substrings;
    }

    /**
     * Restores the characters from the given indices to form a string.
     * @param indices The indices of the characters to be restored.
     * @return The restored string.
     */
    public String restoreString(int[] indices) {
        validateIndicesLength(indices);

        StringBuilder restoredString = new StringBuilder();

        for (int index : indices) {
            validateCharacterIndex(index);
            restoredString.append(string.charAt(index));
        }

        return restoredString.toString();
    }

    // Private helper methods for input validation

    private void validateCharacterIndex(int index) {
        if (index <= 0 || index > string.length()) {
            throw new IndexOutOfBoundsException("Invalid character index");
        }
    }

    private void validateWordIndices(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid word indices");
        }
    }

    private void validateIndicesLength(int[] indices) {
        if (indices.length != string.length()) {
            throw new IllegalArgumentException("Invalid indices length");
        }
    }
}
