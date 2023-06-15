/*
Aravind Sripada
CS410 - Sara Farag
6/13/2023
This file contains the implementations for the string manipulations class.
*/
public class StringManipulation implements StringManipulationInterface {

    String current = null;
    @Override
    public String getString() {
        return current;
    }

    @Override
    public void setString(String string) {
        current = string;
    }

    @Override
    public int count() {
        if(current == null || current.isEmpty()) //empty or null string have a length of 0
            return 0;

        String[] wordcount = current.trim().split(" "); //gets rid of whitespace from the front and back
        return wordcount.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if(current == null || current.isEmpty())
            return current;

        if(n <= 0 ) {
            throw new IllegalArgumentException();
        }

        if(n > current.length()) {
            throw new IndexOutOfBoundsException();
        }

        int replacedDigit = n;
        String replaced = "";
        for(int i = 0; i < current.length(); i++) {
            if(i != replacedDigit - 1) {
                replaced += current.charAt(i);
            } else {
                replacedDigit += n;
                if(maintainSpacing)
                    replaced += " ";
            }
        }
        return replaced;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if(startWord <= 0 || endWord <= 0) {
            throw new IllegalArgumentException();
        }

        int wordcount = count();
        if(startWord > wordcount || endWord > wordcount) {
            throw new IndexOutOfBoundsException();
        }

        int start = startWord - 1; //the given ints are always 1 ahead since they start counting from 1
        int end = endWord - 1;

        String[] words = current.trim().split(" "); //removes white space at the beginning and end of the string and splits by whitespace
        String[] substring = new String[endWord - startWord + 1];

        for(int i = start; i <= end; i++) {
            int substringindex = i - startWord + 1;
            substring[substringindex] = words[i];
        }

        return substring;
    }

    @Override
    public String restoreString(int[] indices){
        if(indices.length != current.length()) {
            throw new IllegalArgumentException();
        }



        String newStr = "";
        for(int i = 0; i < indices.length; i++) {
            if(indices[i] < 0 || indices[i] > current.length() - 1) {
                throw new IndexOutOfBoundsException();
            }
            newStr += current.charAt(indices[i]);
        }

        return newStr;
    }


}
