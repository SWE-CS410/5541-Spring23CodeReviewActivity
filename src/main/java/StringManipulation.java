import java.util.Arrays;

public class StringManipulation implements StringManipulationInterface {
	
	private String[] wordArray;
	
    @Override
    public String getString() {
    	if (wordArray == null) {
    		throw new NullPointerException("String has not been set for current StringManipulation object (hint: use setString()).");
    	}
        return String.join(" ", wordArray).trim();
    }

    @Override
    public void setString(String string) {
    	if (string.isBlank()) {
    		wordArray = new String[] { string };
    	}
    	else {
    		wordArray = string.split(" ");
    	}
    }

    @Override
    public int count() {
    	if (wordArray == null) {
    		return -1;
    	}
    	if (getString().isBlank()) {
    		return 0;
    	}
        return wordArray.length;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
    	String retVal = getString();
    	
    	if (n <= 0) {
    		throw new IllegalArgumentException("First argument is less than or equal to zero.");
    	}
    	if (n > retVal.length()) {
    		throw new IndexOutOfBoundsException("Passed " + n + " as first argument. " + n + " is greater than length of current StringManipulation object: " + retVal.length());
    	}
    	if (n == 1) {
    		return maintainSpacing ? generateSpaces(retVal.length()) : "";
    	}
    	if (maintainSpacing) {
        	for (int i = n - 1; i < retVal.length(); i += n) {
        		retVal = retVal.substring(0, i) + " " + retVal.substring(i + 1);
        	}  		
    	}
    	else {
        	for (int i = n - 1; i < retVal.length(); i += n) {
        		retVal = retVal.substring(0, i) + retVal.substring(i + 1);
        		i--;
        	} 		
    	}
        return retVal;
    }
    
    /**
     * Returns a string consisting of n spaces
     * 
     * Example
     *   Method Call: generateSpaces(5);
     * 	 Return:      "     "
     * 
     * @param  n  Determines the number of spaces to return
     * @return    String consisting of n spaces
     */
    public String generateSpaces(int n) {
    	if (n < 0) {
    		throw new IllegalArgumentException("Cannot generate negative number of spaces.");
    	}
		String retVal = "";
		for (int i = 0; i < n; i++) {
			retVal += " ";
		}
		return retVal;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord) {
    	if (wordArray == null) {
    		throw new NullPointerException("String has not been set for current StringManipulation object (hint: use setString()).");
    	}
    	if (startWord <= 0) {
    		throw new IllegalArgumentException("Index for startWord (first argument) must be greater than or equal to 1.");
    	}
    	if (endWord <= 0) {
    		throw new IllegalArgumentException("Index for endWord (second argument) must be greater than or equal to 1.");
    	}
    	if (startWord > endWord) {
    		throw new IllegalArgumentException("Index for startWord (first argument) must be less than index for endWord (second argument).");
    	}
    	if (endWord > count()) {
    		throw new IndexOutOfBoundsException("Index of endWord is greater than word count for current StringManipulation object.");
    	}
        return Arrays.copyOfRange(wordArray, startWord - 1, endWord);
    }

    @Override
    public String restoreString(int[] indices) {
    	String currentString = getString();
    	if (currentString.length() != indices.length) {
    		throw new IllegalArgumentException("Length mismatch between number of words in current StringManipulation object and length of given indices array.");
    	}
    	String[] retVal = new String[currentString.length()];
    	for (int i = 0; i < indices.length; i++) {
    		if (indices[i] < 0) {
    			throw new IndexOutOfBoundsException("Invalid index: Element at index " + i + " in passed array is less than zero.");
    		}
    		if (indices[i] >= currentString.length()) {
    			throw new IndexOutOfBoundsException("Invalid index: Element at index " + i + " in passed array is GTE the length of the current StringManipulation object.");
    		}
    		retVal[indices[i]] = String.valueOf(currentString.charAt(i));
    	}
        return String.join("", retVal);
    }
}
