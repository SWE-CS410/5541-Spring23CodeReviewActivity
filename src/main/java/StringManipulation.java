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
    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else if (n > string.length()) {
            throw new IndexOutOfBoundsException();
        }

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
    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException();
        }

        String[] preFilteredResult = string.split(" ");
        String[] substrings = new String[endWord - startWord + 1];
        int wordCount = 1;
        int substringsIndex = 0;
        
        for (String result : preFilteredResult) {
            if (!result.isEmpty()) {
                if (wordCount >= startWord && wordCount <= endWord) {
                    substrings[substringsIndex] = result;
                    substringsIndex++;
                }
                wordCount++;
            }
        }

        if (wordCount < endWord) {
            throw new IndexOutOfBoundsException();
        }

        return substrings;
    }

    /**
     * Restores the characters from the given indices to form a string.
     * @param indices The indices of the characters to be restored.
     * @return The restored string.
     */
     @Override
    public String restoreString(int[] indices){
        if (indices.length != string.length()) {
            throw new IllegalArgumentException();
        }

        String[] restoredStringArray = new String[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int oldIndex = indices[i];
            if (oldIndex < 0 || oldIndex >= string.length()) {
                throw new IndexOutOfBoundsException();
            }
            restoredStringArray[i] = String.valueOf(string.charAt(oldIndex));
        }

        return String.join("", restoredStringArray);
    }

}
