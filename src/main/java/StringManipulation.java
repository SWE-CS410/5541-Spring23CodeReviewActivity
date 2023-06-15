public class StringManipulation implements StringManipulationInterface {

    private String _string;

    @Override
    public String getString() {
        return _string;
    }

    @Override
    public void setString(String string) {
        _string = string;
    }

    @Override
    public int count() {
        String string = getString();
        String[] words = string.split("\\s+");
        return words.length;

    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        String string = getString();
        StringBuilder result = new StringBuilder();

        // exception throw IndexOutOfBoundsException
        if (n > string.length()) {
            throw new IndexOutOfBoundsException("n is more then string ");
        }
        // exception throw IllegalArgumentException
        if (n <= 0) {
            throw new IllegalArgumentException("n is less then or equal to zero");
        }

        int  target_n = n;
        for (int i = 0; i < string.length(); i++) {

            // gets character
            char c = string.charAt(i);

            // if i is not equal to n then it add charter
            if (i != target_n-1) {
                result.append(c);

            }
            else {
                if(maintainSpacing) {

                    result.append(' ');

                }
                target_n += n;
            }


        }
        return result.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
        // get number of words
        int numberOfWords = count();
        String string = getString();
        String[] words = string.split("\\s+");


        // exception throw IndexOutOfBoundsException

        if (numberOfWords < endWord) {
            throw new IndexOutOfBoundsException("string has less then endword  ");
        }
        // exception throw IllegalArgumentException

        if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
            throw new IllegalArgumentException("startword or endword is invalid ");
        }

        String[] substrings = new String[endWord - startWord + 1];

        int count = 0;
        for (int i = startWord-1; i <= endWord-1;i++){
            substrings[count] = words[i];
            count++;
        }
        return substrings;
    }

    @Override
    public String restoreString(int[] indices) {
        String string = getString();
        int stringSize = string.length();

        System.out.println("The count is: " + stringSize+ "indices.length = "+indices.length);


        // exception throw IllegalArgumentException

        if (stringSize != indices.length ) {
            throw new IllegalArgumentException("length of indices does not match string length ");
        }



        char[] stringOutPut = new char[indices.length];

        for (int i = 0; i < stringSize; i++) {
            int index = indices[i];


            // exception throw IndexOutOfBoundsException
            //indices.length
            if (index < 0 || index >= stringSize) {
                throw new IndexOutOfBoundsException("string has less then endword  ");
            }

            stringOutPut[i] = string.charAt(index);

        }
        return new String(stringOutPut);
    }
}
