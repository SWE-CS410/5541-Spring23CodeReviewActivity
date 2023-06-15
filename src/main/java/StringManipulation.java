public class StringManipulation implements StringManipulationInterface {
    String myString;
    @Override
    public String getString() {
        return null;
    }

    @Override
    public void setString(String string) {
        this.myString = string;
    }

    @Override
    public int count() {
        int tally = 0;
        if(myString == null || myString.length() == 0){
            return tally;
        }
        // "    here is a string" 4
        // "a here is a string" 4
        // "a " 1
        // "here" 1
        for (int i = 0; i < myString.length(); i++){
            char currentChar = myString.charAt(i);
            if(currentChar != ' '){
                tally++;
                while(currentChar != ' '){
                    i++;
                    if(i >= myString.length()){
                        break;
                    }
                    currentChar = myString.charAt(i);
                }
            }
            while (currentChar == ' '){
                i++;
                if(i >= myString.length()){
                    break;
                }
                currentChar = myString.charAt(i);
            }
            

        }
        return tally;
    }

    @Override
    // n = 3; aaabbbaaaccc -> aabbaacc
    //
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if(n <= 0){
            throw new IllegalArgumentException("n must be greater than or equal to 0");
        }
        else if (n > myString.length()){
            throw new IndexOutOfBoundsException(n);
        }
        String buildString = "";
        if (maintainSpacing) {
            if (n == 1){
                for (int i = 0; i  < myString.length(); i++){
                    buildString += " ";
                }
                return buildString;
            }
            int prior = 0;
            for(int i = 0; i < myString.length(); i++){
                if ((i+1) % n == 0){
                    String slice = myString.substring(prior, i);
                    buildString += slice;
                    buildString += " ";
                    prior = i + 1;
                }
                if (i == myString.length() - 1 && myString.length() % n != 0){
                    String slice = myString.substring(prior);
                    buildString += slice;
                }
            }
        }
        else {
            // todo need to update criteria for n == 1
            if (n == 1){
                return buildString;
            }
            int prior = 0;
            for(int i = 0; i < myString.length(); i++){
                if ((i+1) % n == 0){
                    String slice = myString.substring(prior, i);
                    buildString += slice;
                    prior = i + 1;
                }
                if (i == myString.length() - 1 && myString.length() % n != 0){
                    String slice = myString.substring(prior);
                    buildString += slice;
                }
            }
        }
        return buildString;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord <= 0 || endWord <= 0 || endWord < startWord){
            throw new IllegalArgumentException();
        }
        int numWords = this.count();
        if (endWord > numWords){
            throw new IndexOutOfBoundsException(endWord);
        }
        String[] array = new String[1 + endWord - startWord];
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        int arrayPosition = 0;
        int wordCount = 0;
        while(array[array.length - 1] == null){
            char firstChar = myString.charAt(0);
            for (int i = 0; i < myString.length(); i++){
                char currentChar = myString.charAt(i);
                while (currentChar == ' '){
                    i++;
                    if(i >= myString.length()){
                        return array;
                    }
                    currentChar = myString.charAt(i);
                }
                String currentWord = "";
                while(currentChar != ' '){
                    i++;
                    currentWord += String.valueOf(currentChar);
                    if(i == myString.length()){
                        array[arrayPosition] = currentWord;
                        return array;
                    }
                    currentChar = myString.charAt(i);
                }
                wordCount++;
                if(wordCount >= startWord){
                    array[arrayPosition] = currentWord;
                    arrayPosition++;
                }
                if (arrayPosition >= array.length){
                    return array;
                }
            }
        }
        return array;
    }

    @Override
    public String restoreString(int[] indices){
        if(indices.length != myString.length()){
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < indices.length; i++){
                int num = indices[i];
                if(num > myString.length() - 1 || num < 0){
                    throw new IndexOutOfBoundsException(i);
                }
            }
        }
        String convString = "";
        String[] arrayString = new String[myString.length()];
        String[] converted = new String[myString.length()];
        for(int i = 0; i < myString.length(); i++){
            String currentLetter = String.valueOf(myString.charAt(i));
            arrayString[i] = currentLetter;
        }
        for(int i = 0; i < myString.length(); i++){
            int index = indices[i];
            converted[i] = arrayString[index];
        }
        for (int i = 0; i < myString.length(); i++){
            convString += converted[i];
        }
        return convString;
    }
}
