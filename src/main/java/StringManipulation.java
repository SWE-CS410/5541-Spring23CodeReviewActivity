/*
        Sean Fite
        CS 410 Junit Project
        This program implements logic for String Manipulation methods
        Last Updated 6/7/23
        */
public class StringManipulation implements StringManipulationInterface {

    public String _string;
    @Override
    public String getString() {
        return null;
    }

    @Override
    public void setString(String string) {
        this._string = string;
    }

    // this method returns the number of words in the string passed in
    @Override
    public int count()
    {
        String[] words = _string.split(" ");
        int count = 0;
        for (String sentance : words) {
            if (!sentance.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    // method to remove every nth character from string
    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing)
    {
        int index;
        int nthValue = n;
        int indexDeleted = 0;
        String word = _string;
        StringBuilder newWord = new StringBuilder(word);                // using StringBuilder to manipulate string
        if( n <= 0 || word == null)                 // if invalid input, throw exception
        {
            throw new IllegalArgumentException("Invalid Input");
        }
        if(n > word.length())
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for(int i = 0; i < word.length(); i++)                  // loop through entire string
        {
            if(i == n - 1)                                      // if at nth place
            {
                if(maintainSpacing == true)                     // depending on if spacing is maintained
                {
                    newWord.replace(i, i + 1, " ");    // either replace letter with " "
                }
                else
                {
                    newWord.deleteCharAt(i - indexDeleted);     // or replace letter
                }
                indexDeleted++;                             // track changing string length
                n += nthValue;                              // logic to track every nth value
            }
        }
        return newWord.toString();
    }

    // method to return substrings
    @Override
    public String[] getSubStrings(int startWord, int endWord)
    {
        int start = 0;
        String word = _string;
        String[] words = word.split("\\s+");                     // split words using spaces
        String[] wordsWithParams = new String[2];                   // new array to return desired output
        if(startWord > endWord || startWord <= 0 || endWord <= 0)   // if input is not valid, throw exceptions
        {
            throw new IllegalArgumentException("Invalid input");
        }
        if(endWord > words.length)
        {
            throw new IndexOutOfBoundsException("endWord index out of bounds");
        }
        for(int i = startWord; i <= endWord; i++)                   // loop only from start to end params
        {
            if(i == startWord || i == endWord)                      // if we have a match
            {
                wordsWithParams[start] = words[i - 1];              // add to recently initiliaze array
                start++;
            }
        }
        return wordsWithParams;
    }

    // method to change string based on given indices
    @Override
    public String restoreString(int[] indices)
    {
        String word = _string;
        StringBuilder restoredString = new StringBuilder(word);             // using StringBuilder to manipulate string
        if(word.length() != indices.length)                                 // if input is invalid, throw exception
        {
            throw new IllegalArgumentException("Input length does not match string");
        }
        for(int i = 0; i < word.length(); i++)
        {
            if(indices[i] < 0 || indices[i] > word.length())     // if indices values are out of range, throw exception
            {
                throw new IndexOutOfBoundsException("Indices value out of accepted range");
            }
            for(int j = 0; j < word.length(); j++)              // start of nest loops to iterate for matches
            {
                if(i == indices[j])                         // replace StringBuilder values using string word
                {
                    restoredString.replace(j, j + 1, String.valueOf(word.charAt(i)));
                }
            }
        }
        return restoredString.toString();
    }
}

