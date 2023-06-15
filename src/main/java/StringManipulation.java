/////////////////////////////////////////////////////////
//
//  Class: StringManipulation
//  Author: Caleb Rector
//  Date: 6/11/2023
// 
//  Description: Implements methods in StringManipulationInterface
//
/////////////////////////////////////////////////////////

public class StringManipulation implements StringManipulationInterface {

    private String s;

    @Override
    public String getString() {
        return s;
    }

    @Override
    public void setString(String string) {
        s = string;
    }

    @Override
    public int count() {
        if(s.length() == 0)
            return 0;

        String[] arr = s.split("[\\s\\n]");
        return arr.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {

        if (n > s.length())
            throw new IndexOutOfBoundsException();
        if (n <= 0)
            throw new IllegalArgumentException();

        String s2 = "";
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (count == n) {
                if (maintainSpacing)
                    s2 += " ";
                count = 1;
            } else {
                s2 += s.charAt(i);
                count++;
            }
        }
        return s2;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {

        if (startWord <= 0 || endWord <= 0 || startWord > endWord)
            throw new IllegalArgumentException();

        String[] arr = s.split("[\\s\\n]");
        if (arr.length < endWord)
            throw new IndexOutOfBoundsException();

        String[] ret = new String[endWord - startWord + 1];
        for (int i = 0; i < ret.length; i++)
            ret[i] = arr[i + startWord - 1];

        return ret;
    }

    @Override
    public String restoreString(int[] indices) {

        if (indices.length != s.length())
            throw new IllegalArgumentException();

        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            if (indices[i] >= s.length() || indices[i] < 0)
                throw new IndexOutOfBoundsException();
            ret += s.charAt(indices[i]);
        }
        return ret;
    }

}
