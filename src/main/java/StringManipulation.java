import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {

    private String string;

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int count() {
        //If string is null or blank, return 0.
        if(this.string == null || this.string.isBlank()) return 0;

        /*
        Otherwise, get the number of words in string, which are
        separated by one or more whitespace characters.
         */
        return string.split("\\s+").length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        //check null string
        if(this.string == null) return null;
        // check n <= 0
        if(n <= 0) throw new IllegalArgumentException("N must be greater than 0");
        // check n > string string
        if(n > this.string.length()) throw new IndexOutOfBoundsException("Index out of bounds");
        //edge cases
        if(n == 1 && !maintainSpacing) return "";
        if(n == 1 && maintainSpacing) return this.string.replaceAll(".", " ");

        StringBuilder b = new StringBuilder();
        for(int i = 0; i < this.string.length(); i++) {
            if((i+1) % n == 0) {
                if(maintainSpacing) b.append(' ');
            } else {
                b.append(this.string.charAt(i));
            }
        }
        return b.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        //check null string
        if(this.string == null) return null;
        //check startWord <= 0
        if(startWord <= 0) throw new IllegalArgumentException("startWord must be greater than zero");
        //check endWord <= 0
        if(endWord <= 0) throw new IllegalArgumentException("endWord must be greater than zero");
        //check startWord > endWord
        if(startWord > endWord) throw new IllegalArgumentException("startWord cannot be larger than endWord");
        //check string.count() < endWord
        if(this.count() < endWord) throw new IndexOutOfBoundsException("endWord cannot be larger than the total word count");

        return Arrays.copyOfRange(this.string.split("\\s+"), startWord-1, endWord);
    }

    @Override
    public String restoreString(int[] indices) {
        //check null string
        if(this.string == null) return null;
        //check unequal lengths
        if(this.string.length() != indices.length) throw new IllegalArgumentException("String length must match array length");
        //check valid indices
        for(int i = 0; i < indices.length; i++) {
            if(indices[i] < 0 || indices[i] >= this.string.length()) throw new IndexOutOfBoundsException("Invalid array index");
        }
        //average case
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < indices.length; i++) {
            b.append(this.string.charAt(indices[i]));
        }
        return b.toString();
    }


}
