public class StringManipulation {

    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int count() {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        String[] words = string.trim().split("\\s+");
        return words.length;
    }

    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value for n");
        }
        if (string == null || string.isEmpty() || n > string.length()) {
            throw new IndexOutOfBoundsException("n is greater than the string length");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if ((i + 1) % n != 0) {
                result.append(string.charAt(i));
            } else if (maintainSpacing) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    public String[] getSubStrings(int startWord, int endWord) {
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord values");
        }
        if (string == null || string.isEmpty()) {
            throw new IndexOutOfBoundsException("String is empty");
        }

        String[] words = string.trim().split("\\s+");
        if (endWord > words.length) {
            throw new IndexOutOfBoundsException("String has fewer words than endWord");
        }

        String[] substrings = new String[endWord - startWord + 1];
        int index = 0;
        for (int i = startWord - 1; i < endWord; i++) {
            substrings[index] = words[i];
            index++;
        }
        return substrings;
    }

    public String restoreString(int[] indices) {
        if (string == null || indices == null || string.length() != indices.length) {
            throw new IllegalArgumentException("Invalid input: string length does not match indices length");
        }

        char[] charArray = string.toCharArray();
        char[] restoredArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int index = indices[i];
            if (index < 0 || index >= charArray.length) {
                throw new IndexOutOfBoundsException("Invalid index value");
            }
            restoredArray[index] = charArray[i];
        }
        return new String(restoredArray);
    }
}
