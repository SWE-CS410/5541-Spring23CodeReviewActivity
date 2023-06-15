public class StringManipulation implements StringManipulationInterface {
	
	private String string;
	private int count;
	
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
    	// initialize word count to 0
    	count = 0;
    	
    	// if statement to check if string is null or empty    	
    	if (string == null || string.length() == 0) {
    		return count;
    	}
    	
    	// split the string into a string array, delimiting by one or more spaces
    	String[] wordArray = this.string.split("\\s+");
    	
    	count = wordArray.length;
    	
    	return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {    	
    	if (n > string.length()) {
    		throw new IndexOutOfBoundsException();
    	} else if (n <= 0) {
    		throw new IllegalArgumentException();
    	}
    	
    	// initialize an ArrayList of Characters
    	ArrayList<Character> charArray = new ArrayList<Character>();
    	
    	// iterate through string and insert each Character in the ArrayList
    	for (int i = 0; i < string.length();i ++) {
    		charArray.add(string.charAt(i));
    	}
    	
    	// determine the highest Nth index less than or equal to the length of this.string
    	int limit = string.length() / n;
    	
    	// initialize an int array to hold all the indexes to replace
    	int[] indexesToReplace = new int[limit];
    	
    	// assign each Nth index to an element in the int array
    	for (int i = 1, j = 0; i <= limit; i++, j++) {
    		indexesToReplace[j] = n * i;
    	}
    	
    	//System.out.println("indexes to replace:    " + Arrays.toString(indexesToReplace));
    	
    	// iterate through the ArrayList and replace the Character with space or delete
    	for (int i = indexesToReplace.length - 1; i >= 0; i--) {
    		int index = indexesToReplace[i] - 1;
    		
    		if (maintainSpacing == true) {
    			charArray.set(index, ' ');
    		}
    		
    		if (maintainSpacing == false) {
    			charArray.remove(index);
    		}
    	} 
    	
    	// build the string from the ArrayList and return to main
    	StringBuilder stringBuilder = new StringBuilder();
    	for (char c : charArray) {
    		stringBuilder.append(c);
    	}

    	return stringBuilder.toString();
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
    	// exception: If either "startWord" or "endWord" are invalid
    	if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
    		throw new IllegalArgumentException();
    	}
    	
    	// exception: If the string has less than "endWord" words in it
    	if (count() < endWord) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	// split the words into a String array, delimited by one or more spaces
    	String[] arr = this.string.split("\\s+");
    	
    	// intialize the return array with size of the number of words to keep
    	String[] finalArray = new String[endWord - startWord + 1];
    	
    	// iterate through the array of all words, if the index falls inside the
    	// range passed in, then put that word in the new array
    	for (int i = 0, j = 0; i <= arr.length; i++) {
    		if (i >= startWord && i <= endWord) {
    			finalArray[j] = arr[i - 1];
    			j++;
    		}
    	}

    	return finalArray;
    }

    @Override
    public String restoreString(int[] indices){
    	// exception: if not s.length == indices.length == n
    	if (string.length() != indices.length) {
    		throw new IllegalArgumentException();
    	}
    	
    	// exception: if indices[i] < 0  or  indices[i] > string length
    	for (int i = 0 ; i < indices.length; i++) {
    		if (indices[i] < 0 || indices[i] >= string.length()) {
    			throw new IndexOutOfBoundsException();
    		}
    	}
    	
    	// initialize an ArrayList for the final string to be returned
    	ArrayList<Character> finalWord = new ArrayList<>();
    	
    	// fill the ArrayList with characters from the original string
    	for (char c : string.toCharArray()) {
    		finalWord.add(c);
    	}
    	
    	// iterate through both the indices parameter and the string characters
    	// to load the final array with shuffled characters
    	for (int i = 0; i < string.length(); i++) {
    		finalWord.set(indices[i], string.charAt(i));
    	}
    	
    	// build the string from the ArrayList and return to main
    	StringBuilder stringBuilder = new StringBuilder();
    	for (char c : finalWord) {
    		stringBuilder.append(c);
    	}
    	
    	return stringBuilder.toString();
    }
}

