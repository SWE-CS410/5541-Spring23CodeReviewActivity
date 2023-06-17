import java.util.*;
public class StringManipulation implements StringManipulationInterface {
    private String pString;

    @Override
    public String getString() {
        return pString;
    }

    @Override
    public void setString(String string) {
        this.pString = string;
    }

    @Override
    public int count() {
        if(pString == null || pString.isEmpty()){
            return 0;
        }

        String[] words = pString.split("\\s+"); //split string to words using space
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        String theString = getString();

        if(n > theString.length()){
            throw new IndexOutOfBoundsException("N cannot be larger than the length of Sting");
        }

        if(n <= 0){
            throw new IllegalArgumentException("Input n cannot be 0 or negative");
        }

        StringBuilder sb = new StringBuilder(theString);

        if(maintainSpacing){ //replace the nth letter with a space
            for(int i = n-1; i < theString.length(); i += n){
                sb.setCharAt(i, ' ');
            }
            return sb.toString();
        }
        else{
            if(n == 1){ //return empty string
                return "";
            }
            else{ //delete nth letter without spacing
                for(int i = n-1; i < theString.length(); i += n){
                    while (i < sb.length()){
                        sb.deleteCharAt(i);
                        i += n - 1;
                    }
                }
                return sb.toString();
            }
        }
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if(startWord <= 0 || endWord <= 0 || startWord > endWord){
            throw new IllegalArgumentException("Invalid startWord or endWord");
        }

        String[] words = getString().split("\\s+"); //split string to words using space

        if(words.length < endWord){
            throw new IndexOutOfBoundsException("String has less than 'endWord' words");
        }
        //returns a copy of array that only include startWord to endWord
        return Arrays.copyOfRange(words, startWord - 1, endWord);
    }

    @Override
    public String restoreString(int[] indices){
        if(indices == null || this.pString == null) {
            throw new IllegalArgumentException("There are no input");
        }

        if(indices.length == 0 || this.pString.length() == 0){
            throw new IllegalArgumentException("The indices or String is 0");
        }

        if(indices.length != this.pString.length()) {
            throw new IllegalArgumentException("String length and indices length are not equal");
        }

        char[] shuffledString = new char[indices.length]; //creating new char array of length indices

        for(int i = 0; i < indices.length; i++) { //for each index in indices
            if(indices[i] < 0 || indices[i] >= this.pString.length()) {
                throw new IndexOutOfBoundsException("The indices " + indices[i] + " is out of bounds");
            }
            shuffledString[i] = this.pString.charAt(indices[i]); //shuffles string in the order of indices
        }

        return new String(shuffledString);
    }
}
