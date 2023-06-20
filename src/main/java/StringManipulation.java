

public class StringManipulation implements StringManipulationInterface {

    private String str;

    public String getString() {
        return this.str;
    }

    public void setString(String string) {
        this.str = string;
    }


    public int count() {
        if (this.str == null || this.str.equals("")) {
            return 0;
        }
        return this.str.trim().split("\\s+").length;
    }


    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        if (str == null) {
            return null;
        }
        if (n > this.str.length()) {
            throw new IndexOutOfBoundsException("n is greater than the string length");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.str.length(); i++) {
            if ((i + 1) % n == 0) {
                if (maintainSpacing) {
                    sb.append(' ');
                }
            } else {
                sb.append(this.str.charAt(i));
            }
        }
        return sb.toString();
    }


    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord");
        }
        if (str == null)
            return null;
        String[] words = this.str.trim().split("\\s+");
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("The string has less than 'endWord' words in it");
        }

        // Manually create new array and copy the desired range into it
        String[] subStrings = new String[endWord - startWord + 1];
        System.arraycopy(words, startWord - 1, subStrings, 0, subStrings.length);

        return subStrings;
    }


    public String restoreString(int[] indices) {
        if (this.str == null )
            return null;
        if (indices.length != this.str.length()) {
            throw new IllegalArgumentException("String length and indices array length must be the same");
        }
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= this.str.length()) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            result[indices[i]] = this.str.charAt(i);
        }
        return new String(result);
    }
}
