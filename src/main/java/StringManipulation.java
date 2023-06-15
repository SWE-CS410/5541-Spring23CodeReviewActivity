public class StringManipulation implements StringManipulationInterface {
	private String str;

	@Override
	public String getString() {
		return this.str;
	}

	@Override
	public void setString(String string) {
		this.str = string;
	}

	@Override
	public int count() {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		
		String[] splitStr = str.split("\\s+");
		return splitStr.length;
		/*
		 * int wordCount = 0;
		boolean whitespace = false;

		// Iterate through each character in the string
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// Check if the character is a whitespace
			if (Character.isWhitespace(c)) {
				whitespace = true;
			
			// Check if the character is a letter or digit
			if (Character.isLetterOrDigit(str.charAt(i+1))) {
				// If we are not inside a word, increment the word count
				if (whitespace) {
					wordCount++;
					whitespace = false;
				}
				}*/
	}

	@Override
	public String removeNthCharacter(int n, boolean maintainSpacing) {
		if (n <= 0) {
			throw new IllegalArgumentException("'n' must be greater than zero.");
		}

		if (n > str.length()) {
			throw new IndexOutOfBoundsException("'n' is greater than the string length.");
		}

		String result = new String();
		result = result.concat(str.charAt(0) + "");
		for (int i = 1; i < str.length(); i++) {
			if((i+1) % n != 0) {
				result = result.concat(str.charAt(i) + "");
			}
			else {
				if (maintainSpacing) {
					result = result.concat(" ");
				}
			} 
		}
		
		return result;
	}

	@Override
	public String[] getSubStrings(int startWord, int endWord) {
		// Check for invalid arguments
		if (startWord <= 0 || endWord <= 0 || startWord > endWord) {
			throw new IllegalArgumentException("Invalid startWord or endWord");
		}

		// Split the sentence into words
		String[] words = str.split("\\s+");

		// Check if the sentence has enough words
		if (endWord > words.length) {
			throw new IndexOutOfBoundsException("The String has less than " + endWord + " words");
		}

		// Calculate the number of words to put in the array
		int wordCount = endWord - startWord + 1;

		// Create a new array to store the extracted words
		String[] subStrArr = new String[wordCount];

		// Extract the words from the specified positions
		for (int i = 0; i < wordCount; i++) {
			subStrArr[i] = words[startWord - 1 + i];
		}

		return subStrArr;
	}

	@Override
	public String restoreString(int[] indices) {
		//throws IllegalArgumentException if not s.length == indices.length == n
	    // throws IndexOutOfBoundsException if   indices[i]< 0  or  indices[i]> string length
		if(str.length() != indices.length) {
			throw new IllegalArgumentException("The indices array must be the same length as the string.");
		}
		char[] temp = str.toCharArray();
		char[] shuffled = new char[str.length()];
		String output = new String();
		for(int i = 0; i < str.length(); i++) {
			if(i < indices.length) {  
				int pos = indices[i];
				if(pos < 0 || pos > str.length()) {
					throw new IndexOutOfBoundsException("All values in the indices array must correspond to valid indexes in the string.");
				}
				shuffled[pos] = temp[i];
		    }
			else{
				shuffled[i] = temp[i];
			}
		}
		output = String.valueOf(shuffled);
		return output;
	}

}
