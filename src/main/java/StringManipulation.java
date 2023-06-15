import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {

    private String myString;
    @Override
    public String getString() {
        return myString;
    }

    @Override
    public void setString(String string) {
        myString = string;
    }

    @Override
    public int count() {
        int countWords = myString.split("\\w+").length;
        if (myString.charAt(0) == ' ') countWords --;
        return countWords;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n > myString.length()) {
            throw new IndexOutOfBoundsException ("n is greater than the string length");
        }
        if (n <= 0) {
            throw  new IllegalArgumentException("n can not be less than or equal to zero");
        }
        String str = "";
        for (int i = 0; i < myString.length(); i++) {
            if (i%n != n-1) {
                str += myString.charAt(i);
            } else {
                if (maintainSpacing) str += " ";
            }
        }
        return str;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) throw new IllegalArgumentException("invalid input for index");
        if (count() < startWord || count() < endWord) throw new IndexOutOfBoundsException("index is out of bound");
        String[] words = myString.split("\\s");
        String[] substring;
        substring = new String[endWord-startWord+1];
        int cnt = 0;
        for (int i = startWord-1; i < endWord; i++) {
            substring[cnt] = words[i];
            cnt++;
        }
        return substring;
    }

    @Override
    public String restoreString(int[] indices){
        if (myString.length() != indices.length) throw new IllegalArgumentException("index values does not match the string");
        String str = "";
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= myString.length()) throw new IndexOutOfBoundsException("Invalid index input");
            for (int j = 0; j < indices.length; j++) {
                if (indices[j] == i) {
                    str += myString.charAt(j);
                }
            }
        }
        return str;
    }


}
