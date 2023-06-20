/* Chris Nevares
 * 6/11/23
 * CS410, Spring 2023
 * Junit Testing Assignment - StringManipulationTest
 *
 * The StringManipulation class provides various ways to manipulate an input string
 * Most methods deal with the number of words in the input string.
 *
 */



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation implements StringManipulationInterface {
    private String myString = null;
    @Override

    public String getString() {
        return this.myString;
    }

    @Override
    public void setString(String string) {

        this.myString = string;
    }

    @Override
    public int count() {
        if(myString == null) {
            throw new NullPointerException("String is null.");
        }
        String regex = "\\w*['-]?\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(myString);
        int wordCount = 0;
        while(matcher.find()) {
            wordCount++;
        }

        return wordCount;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing)  {
        if(myString == null) {
            throw new NullPointerException("String is null.");
        }
        if(n > myString.length()) {
            throw new IndexOutOfBoundsException("n is greater than string length.");
        }
        if(n <= 0) {
            throw new IllegalArgumentException("n is less than or equal to 0.");
        }

        String outputString = "";
        int index = n - 1;
        for(int i = 0; i < myString.length(); i++) {
            if(i == index) {
                if(maintainSpacing) {
                    outputString += " ";
                } else {
                    outputString +="";
                }
                index = index + n;
            } else {
                outputString += myString.charAt(i);
            }
        }
        return outputString;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if(startWord <=0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord and/or endWord value.");
        }
        if(endWord > count()) {
            throw new IndexOutOfBoundsException("endWord > number of words in string.");
        }

        String[] stringArray = new String[endWord - startWord + 1];
        Pattern pattern = Pattern.compile("\\w*['-]?\\w+");
        Matcher matcher = pattern.matcher(myString);
        int wordCount = 0;

        while(matcher.find()) {
            wordCount++;
            if(wordCount >= startWord && wordCount <= endWord) {
                stringArray[wordCount - startWord] = matcher.group();
            }
        }
        return stringArray;
    }

    @Override
    public String restoreString(int[] indices){
        if(indices.length != myString.length()) {
            throw new IllegalArgumentException("Integer array must be same length as string.");
        }

        String outputString = "";

        for(int i = 0; i < indices.length; i++) {
            if(indices[i] < 0 || indices[i] >= myString.length()) {
                throw new IndexOutOfBoundsException("Invalid integer element at index" + i +".");
            }
            outputString += myString.charAt(indices[i]);
        }
        return outputString;
    }


}
