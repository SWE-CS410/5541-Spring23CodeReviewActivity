//Alvin Bautista
//CS 410 - JUNIT Assignment
//06112023

package main.java;

public class StringManipulation implements StringManipulationInterface {

    private String string; //stores the string to manipulate

    @Override
    public String getString() {
        return this.string; //return the string stored in this object
    }

    @Override
    public void setString(String string) {
        this.string = string; //set the string stored in this object
    }

    @Override
    public int count() {
        //check if the string is null or empty
        if (this.string == null || this.string.trim().isEmpty()) {
            return 0;
        }
        //split the string into words and return the number of words
        return this.string.trim().split("\\s+").length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        //validate n
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }

        //special case when n is 1
        if (n == 1) {
            return this.string; //return original string
        }

        //validate the string
        if (this.string == null) {
            throw new IndexOutOfBoundsException("String is null");
        }

        //validate that n is not greater than string length
        if (n > this.string.length()) {
            throw new IndexOutOfBoundsException("n is greater than the string length");
        }

        //initialize a StringBuilder to build the result
        StringBuilder result = new StringBuilder();

        //loop through characters of the string
        for (int i = 1; i <= this.string.length(); i++) {
            //append character to result if its position is not a multiple of n
            if (i % n != 0) {
                result.append(this.string.charAt(i - 1));
            } else {
                //append space to result if maintainSpacing is true and position is multiple of n
                if (maintainSpacing) {
                    result.append(' ');
                }
            }
        }

        //return the resulting string
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        //validate startWord and endWord
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord");
        }

        //validate the string
        if (this.string == null) {
            throw new IndexOutOfBoundsException("String is null");
        }

        //split string into words
        String[] words = this.string.split("\\s+");

        //check if there are enough words to get the substring
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("String has fewer than endWord words");
        }

        //create array to store the substrings
        String[] subStrings = new String[endWord - startWord + 1];

        //copy the substrings into the array
        System.arraycopy(words, startWord - 1, subStrings, 0, subStrings.length);

        //return the substrings array
        return subStrings;
    }

    @Override
    public String restoreString(int[] indices) {
        //validate the indices and the string
        if (indices == null || this.string == null || indices.length != this.string.length() || indices.length == 0) {
            throw new IllegalArgumentException("String and indices should have the same non-zero length");
        }

        //create an array to store characters in the restored order
        char[] restored = new char[this.string.length()];

        //loop through the indices
        for (int i = 0; i < indices.length; i++) {
            //validate each index
            if (indices[i] < 0 || indices[i] >= this.string.length()) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            //place each character at the correct position
            restored[indices[i]] = this.string.charAt(i);
        }

        //return the restored string
        return new String(restored);
    }
}
