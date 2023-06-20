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
        if (string == null || string.isEmpty()) {
            return 0;
        }

        // Split the string by whitespace and count the number of words
        String[] words = string.split("\\s+");
        return words.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (string == null || string.isEmpty()) {
            return string;
        }

        StringBuilder result = new StringBuilder();
        char[] characters = string.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if ((i + 1) % n != 0) {
                result.append(characters[i]);
            } else if (maintainSpacing) {
                result.append(characters[i]).append(" ");
            }
        }

        return result.toString().trim();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        if (string == null || string.isEmpty()) {
            return new String[0];
        }

        String[] words = string.split("\\s+");
        if (startWord < 1 || startWord > words.length || endWord < 1 || endWord > words.length || startWord > endWord) {
            throw new IllegalArgumentException("Invalid startWord or endWord");
        }

        int numSubStrings = endWord - startWord + 1;
        String[] subStrings = new String[numSubStrings];

        for (int i = 0; i < numSubStrings; i++) {
            subStrings[i] = words[startWord - 1 + i];
        }

        return subStrings;
    }

    @Override
    public String restoreString(int[] indices) {
        if (string == null || string.isEmpty()) {
            return string;
        }

        if (indices.length != string.length()) {
            throw new IllegalArgumentException("Invalid indices length");
        }

        char[] characters = string.toCharArray();
        char[] restored = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index < 0 || index >= indices.length) {
                throw new IllegalArgumentException("Invalid index value");
            }
            restored[index] = characters[i];
        }

        return new String(restored);
    }
}