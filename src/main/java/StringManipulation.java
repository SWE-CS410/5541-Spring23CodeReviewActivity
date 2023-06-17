
import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {

    private String stringToManipulate;

    @Override
    public String getString() {
        return stringToManipulate;
    }

    @Override
    public void setString(String string) {
        stringToManipulate = string;
    }

    @Override
    public int count() {

        // if the current stringToManipulate is null, throws a NullPointerException
        checkForNullString();

        // If the stringToManipulate is an empty string, returns 0
        if(stringToManipulate.length()==0){
            return 0;
        }

        // split the string by whitespace(s), period, comma, and other symbols
        // and stores each word into a String array
        String[] words = stringToManipulate.split("[\\s.(),:?!]+");

        // returns the length of array as the word count
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        // if the current stringToManipulate is null, throws a NullPointerException
        checkForNullString();

        // If the given n is smaller or equal to 0, throws IllegalArgumentException
        if(n <= 0){
            throw new IllegalArgumentException("n must be greater than zero.");
        }
        // If the given n is larger than the length of the string, throws IndexOutOfBoundsException
        if(n > stringToManipulate.length()){
            throw new IndexOutOfBoundsException("n must be less than or equal to the length of the string.");
        }

        StringBuilder str = new StringBuilder();
        int length = stringToManipulate.length();

        // Traverse the entire stringToManipulate
        for(int i = 1; i <= length ;i++){
            // As long as the index of stringToManipulate is NOT divisible by n, append the
            // corresponding character to the str
            if(i % n != 0) {
                str.append(stringToManipulate.charAt(i - 1));
            }
            // if the index is divisible by n AND maintainSpacing is true, append a space
            else if(maintainSpacing){
                str.append(' ');
            }
        }

        return str.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){

        // if the current stringToManipulate is null, throws a NullPointerException
        checkForNullString();

        // If the startWord or the endWord is zero or negative, OR the endWord is smaller than the startWord,
        // throws an exception
        if(startWord <= 0 || endWord <= 0 || startWord > endWord)
        {
            throw new IllegalArgumentException("Invalid argument(s) were entered.");
        }

        // Gets the word count by using split()
        String[] words = stringToManipulate.split("[\\s.,_:?!]+");

        // If the endWord is larger than the length of string, throws an exception
        if(endWord > words.length)
        {
            throw new IndexOutOfBoundsException("The endWord entered is out of bounds");
        }

        // copies the words in the specified range into a new array called substring
        String[] substring = Arrays.copyOfRange(words, startWord-1, endWord);

        return substring;
    }

    @Override
    public String restoreString(int[] indices){

        // if the current stringToManipulate is null, throws a NullPointerException
        checkForNullString();

        // If the number of indices are not the same as the length of the string,
        // throws an exception
        if(indices.length != stringToManipulate.length()){
            throw new IllegalArgumentException("The number of indices must match the length of the string.");
        }

        StringBuilder newString = new StringBuilder();

        // Traverse the indices array to the end
        for(int i = 0; i < indices.length; i++){
            // if the index is negative, or larger than equal to the length of the string,
            // throws an exception
            if(indices[i] < 0 || indices[i]>= stringToManipulate.length()){
                throw new IndexOutOfBoundsException("Each index must be between 0 and the length of the string.");
            }
            // otherwise append the character at the index to the new string
            newString.append(stringToManipulate.charAt(indices[i]));
        }
        return newString.toString();
    }

    /* Helper Functions */

    // Helper function to check if the string is null. If so, throw an NullPointerException
    private void checkForNullString(){
        if(stringToManipulate == null) {
            throw new NullPointerException("The string is null.");
        }
    }
}

