public class StringManipulation implements StringManipulationInterface {
    private String myString = "";

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
        String[] spl = myString.split("\\s+");
        int i = 0;
        for (String str : spl) {
            if (!str.equals("")) {
                i++;
            }
        }
        return i;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n > myString.length()) {
            throw new IndexOutOfBoundsException();
        } else if (n <= 0) {
            throw new IllegalArgumentException();
        }
        char[] ar = myString.toCharArray();
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i <= myString.length(); i++) {
            if (i != 0 && i % n == 0) {
                if (maintainSpacing) {
                    ret.append(" ");
                }
            } else {
                ret.append(ar[i - 1]);
            }
        }
        return ret.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0 || endWord < startWord) {
            throw new IllegalArgumentException();
        }
        String[] ret = new String[endWord - startWord + 1];
        String[] spl = myString.split("\\s+");
        if (spl.length < endWord) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = spl[startWord - 1 + i];
        }
        return ret;
    }

    @Override
    public String restoreString(int[] indices){
        if (indices.length != myString.length()) {
            throw new IllegalArgumentException();
        }
        StringBuilder ret = new StringBuilder();
        char[] ar = myString.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= ar.length) {
                throw new IndexOutOfBoundsException();
            }
            ret.append(ar[indices[i]]);
        }
        return ret.toString();
    }


}
