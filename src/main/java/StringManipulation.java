public class StringManipulation implements StringManipulationInterface {
	String str = null;
    @Override
    public String getString() {
        return str;
    }

    @Override
    public void setString(String string) {
    	str = string;
    }

    @Override
    public int count() {
    	//checks for null or 'empty' one char strings, anything more is a bit beyond scope of project
    	if( str == null || str == " ") {
    		return 0;
    	}
        int n = 1;
        for(int i = 1; i < str.length()-1; i++) {
        	//adds a word count at a space, but doesn't count up for multiple spaces in a row, or a space at the end of a string.
        	if(str.charAt(i) == ' ' && str.charAt(i-1) != ' ') {
        		n++;
        	}
        }
        return n;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
    	//exception check
    	String output = "";
    	if(n <= 0) {
    		throw new IllegalArgumentException("n is less than or equal to zero");
    	}
    	if( n > str.length()) {
    		throw new IndexOutOfBoundsException("n is greater than string length");
    	}
    	//iterates over string in increments of n, replacing those words, using substring function of String to grab the other snippets. 
    	for(int i = n; i <= str.length(); i+=n) {
    		output += str.substring(i-n, i-1);
    		if(maintainSpacing) {
    			output += " ";
    		}
    	}
    	//Grabs the remaining portion of the string after the last removed character.
    	int remain = str.length()%n;
    	if(remain != 0) {
    		output += str.substring(str.length() - remain);
    	}
        return output;
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
    	//Exceptions for invalid inputs
    	if(endWord > count() ) {
    		throw new IndexOutOfBoundsException("String has less words than endWord");
    	}
    	
    	if(startWord <= 0) {
    		throw new IllegalArgumentException("startWord must be greater than zero");
    	}
    	if(endWord <= 0) {
    		throw new IllegalArgumentException("endWord must be greater than zero");
    	}
    	if(endWord < startWord) {
    		throw new IllegalArgumentException("endWord must not be less than startWord");
    	}
    	//Creates the string array, sets it to blank so there aren't any null issues.
    	String[] result = new String[endWord-startWord + 1];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = "";
    	}
    	int words = 0;
    	int x = 0;
    	//Iterates over the whole string, only counts where words would be, copying  it into the result
    	for(int i = 0; i < endWord; i++) {
    		while( x < str.length() && str.charAt(x) != ' ') {
    			if(i >= startWord-1) {
    				result[words] += str.charAt(x);
    			}
    			x++;
    		}
    		if(i >= startWord-1) {
    			words++;
			}
    		x++;
    	}
        return result;
    }

    @Override
    public String restoreString(int[] indices){
    	//Exception for incorrect int array
    	if(indices.length != str.length()) {
    		throw new IllegalArgumentException("Number of Indices must equal length of string");
    	}
    	//Create char array of same length of string.
    	char[] result = new char[str.length()];
    	int i = 0;
    	//Iterates over the indices and the string, assigning the string chars based on index values
    	for(int x : indices) {
    		//Exception handling for invalid indices.
    		if(x < 0) {
    			throw new IndexOutOfBoundsException("index must be above 0");
    		}
    		if( x >= str.length() ) {
    			throw new IndexOutOfBoundsException("Index must be under string length");
    		}
    		result[x] = str.charAt(i);
    		i++;
    	}
    	//Use str constructor to convert from char array. 
    	String stringResult = new String(result);
    	return stringResult;
    }


}
