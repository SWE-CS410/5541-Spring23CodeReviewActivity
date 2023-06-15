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
        String[] preFilteredResult = string.split(" ");
        int count = 0;
        
        for (String result : preFilteredResult) {
            if (!result.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else if (n > string.length()) {
            throw new IndexOutOfBoundsException();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if ((i + 1) % n == 0) {
                if (maintainSpacing) {
                    stringBuilder.append(" ");
                }
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException();
        }

        String[] preFilteredResult = string.split(" ");
        String[] substrings = new String[endWord - startWord + 1];
        int wordCount = 1;
        int substringsIndex = 0;
        
        for (String result : preFilteredResult) {
            if (!result.isEmpty()) {
                if (wordCount >= startWord && wordCount <= endWord) {
                    substrings[substringsIndex] = result;
                    substringsIndex++;
                }
                wordCount++;
            }
        }

        if (wordCount < endWord) {
            throw new IndexOutOfBoundsException();
        }

        return substrings;
    }

    @Override
    public String restoreString(int[] indices){
        if (indices.length != string.length()) {
            throw new IllegalArgumentException();
        }

        String[] restoredStringArray = new String[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int oldIndex = indices[i];
            if (oldIndex < 0 || oldIndex >= string.length()) {
                throw new IndexOutOfBoundsException();
            }
            restoredStringArray[i] = String.valueOf(string.charAt(oldIndex));
        }

        return String.join("", restoredStringArray);
    }
}
