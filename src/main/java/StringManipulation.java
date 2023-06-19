public class StringManipulation implements StringManipulationInterface {

    private String string;
    @Override
    public String getString() {

        return string;
    }

    @Override
    public void setString(String string) {

        this.string = string;
    }

    @Override
    public int count() {

        if (string == null || string.isEmpty()){
            return 0;
        }

        String[] words = string.trim().split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value for n: " + n);
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((i + 1) % n != 0) {
                result.append(c);
            } else if (maintainSpacing) {
                result.append(" ");
                count++;
            }
        }

        if (!maintainSpacing && (string.length() % n) == 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }



    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        String[] words = string.split("\\s+");
        int numWords = words.length;

        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("Invalid start or end word");
        }

        if (endWord > numWords) {
            throw new IndexOutOfBoundsException("String has less than " + endWord + " words");
        }

        int subStringLength = endWord - startWord + 1;
        String[] subStrings = new String[subStringLength];
        int subStringIndex = 0;

        for (int i = startWord - 1; i < endWord; i++) {
            subStrings[subStringIndex] = words[i];
            subStringIndex++;
        }

        return subStrings;
    }

    @Override
    public String restoreString(int[] indices){
        if (indices.length != string.length()) {
            throw new IllegalArgumentException("Length of indices array doesn't match string length");
        }

        char[] restoredChars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= indices.length) {
                throw new IndexOutOfBoundsException("Invalid index value in indices array");
            }
            restoredChars[indices[i]] = string.charAt(i);
        }
        return new String(restoredChars);
    }
}


