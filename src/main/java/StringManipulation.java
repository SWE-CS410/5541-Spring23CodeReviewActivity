public class StringManipulation implements StringManipulationInterface {
    private String myString;

    @Override
    public String getString() {
        // Simple check if the String is null or not
        if (myString == null){
            return null;
        }
        else {
            return myString;
        }
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int count() {
        //edge cases if String length equals 0
        if (myString == null || myString.isEmpty()) {
            return 0;
        }
        //excluding all the white space, then add each word into Array
        String[] words= myString.split("\\s+");

        //return the Array length, which is also the length of the string now
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        // Position start at 1, not like index, so throws than error
        if (n <= 0) {
            throw new IllegalArgumentException("'n' must be greater than zero.");
        }

        // n must be smaller than the length of the string
        if (n > myString.length()) {
            throw new IndexOutOfBoundsException("'n' is greater than the string length.");
        }

        //initial an empty string
        String result = "";
        int position = 1;

        for (int i = 0; i < myString.length(); i++) {
            char current = myString.charAt(i);

            //this is to find the 2,4,6 if n=2 or 3,6,9 if n=3,...
            if (position % n != 0) {
                result += current;
            }

            //if maintainSpacing is true then replace that character with a space
            else if (maintainSpacing) {
                result += ' ';
            }

            position++;
        }

        return result;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        // check if the beginning word and end word less than 0 and conflict with each other
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid beginning or end.");
        }

        String[] words = myString.split("\\s+");

        //throw error if the end of the substrings is outside the end of the String.
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("The string has less than 'endWord' words.");
        }

        //length of Substring
        int countWord = endWord - startWord + 1;

        String[] subString = new String[countWord];

        //add the word from String to Substring with the startWord, with -1 to match the right index
        //of the word's array

        for (int i = 0; i < countWord; i++) {
            subString[i] = words[startWord + i - 1];
        }

        return subString;
    }

    @Override
    public String restoreString(int[] indices){
        //throw an error if user put more indices values than the String length
        if (indices.length != myString.length()) {
            throw new IllegalArgumentException("Length of 'indices' must be the same as the string length.");
        }

        //doesn't matter indices length or String length, since it all equals now
        char[] shuffleChar = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            // check if indices value are acceptable
            if (indices[i] < 0 || indices[i] >= indices.length) {
                throw new IndexOutOfBoundsException("Invalid index value.");
            }
            // added the String word to the right indices position
            shuffleChar[indices[i]] = myString.charAt(i);
        }

        return new String(shuffleChar);
    }


}
