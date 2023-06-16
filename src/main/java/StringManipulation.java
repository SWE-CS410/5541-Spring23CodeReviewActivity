

public class StringManipulation implements StringManipulationInterface {
    
    private String myString;
    
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
        if (myString == null) {
            throw new NullPointerException("Cannot count uninitialized string.");
        }
        if (myString.isEmpty() || myString.isBlank()) {
            return 0;
        }
        String[] arrOfStr = myString.split(" ");
        int countOfWords = arrOfStr.length;
        return countOfWords;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        char[] chars = myString.toCharArray();
        String str = null;

        if (n > chars.length) {
            throw new IndexOutOfBoundsException("n cannot be greater than the length of the string");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        if(maintainSpacing) {
            if (n==1) {
                for (int i = 0; i<chars.length; i++) {
                    chars[i] = ' ';
                }
            }
            else if (n>=1) {
                for (int i = 0; i<=chars.length; i=i+n) {
                    if (i == 0) {
                        continue;
                    }
                    int index = i-1;
                    chars[index] = ' ';
                }
            }
            str = String.copyValueOf(chars);
        }
        else if (!maintainSpacing)
        {
            if (n==1) {
                return null;
            }
            char[] temp = new char[chars.length-((int)Math.floor(chars.length/n))];
            if (n>=1)
            {
                for (int i = 0, k=0; i<chars.length && k<temp.length; i++, k++) {
                    for (int j = 0; j<chars.length; j=j+n) {
                        int index = j-1;
                        if (i == 0) {
                            break;
                        }
                        if (index==i) {
                            i++;
                            break;
                        }
                    }
                    temp[k]=chars[i];
                }
            }
            str = String.copyValueOf(temp);
        }
        return str;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord > endWord || startWord <= 0 || endWord <= 0) {
            throw new IllegalArgumentException("startWord must be greater than endWord. Both startWord and endWord must be greater than 0.");
        }

        String[] substr = myString.split(" ");

        if (substr.length < endWord) {
            throw new IndexOutOfBoundsException("endWord cannot be greater than length of substr");
        }

        String[] temp = new String[endWord-startWord+1];
        for (int i = startWord-1, j = 0; i<endWord && j<temp.length; i++, j++) {
            temp[j] = substr[i];
        }
        return temp;
    }

    @Override
    public String restoreString(int[] indices){
        if (myString.length() != indices.length) {
            throw new IllegalArgumentException("the number of indices provides must match positions in the string");
        }
        
        int sumOfIndexes = 0;
        int k = 0;
        for (int i = 0; i<indices.length; i++)
        {
            if (indices[i] > myString.length() || indices[i] < 0) {
                throw new IndexOutOfBoundsException("indices must be within length of the string");
            }
            sumOfIndexes = sumOfIndexes + indices[i];
            k=k+i;
        }
        if (sumOfIndexes != k) {
            throw new IllegalArgumentException("incorrect indexes provided");
        }

        char[] chars = myString.toCharArray();
        char[] temp = new char[chars.length];
        for (int i = 0; i<temp.length; i++) {
            temp[i] = chars[indices[i]];
        }

        String str = String.copyValueOf(temp);
        return str;
    }
}
