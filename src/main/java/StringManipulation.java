import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * The implementation class StringManipulation for the StringManipulationInterface.
 *
 * @author DeWayne Dantzler dewayne.dantler@bellevuecollege.edu
 */
public class StringManipulation implements StringManipulationInterface {
	private String _MyString;
	
	public StringManipulation(){
		_MyString = "";
	}
	
    @Override
    public String getString() {
        return _MyString;
    }

    @Override
    public void setString(String string) {
    	_MyString = string;
    }

    @Override
    public int count() {
    	int count = 0;
    	if(_MyString != null && !_MyString.isEmpty()) {
    		List<String> result = new Scanner(_MyString)
    			     .useDelimiter(" ")
    			     .tokens()
    			     .collect(Collectors.toList());
    		count = result.size();
    	}
    	
    	return count;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
    	//throws IndexOutOfBoundsException If n is greater than the string length.
        if(n > _MyString.length())
            throw new IndexOutOfBoundsException();
    	//throws IllegalArgumentException If "n" less than or equal to zero.
        if(n <= 0)
            throw new IllegalArgumentException();

        char[] arr = _MyString.toCharArray();
        char[] removed = new char[arr.length];
        boolean [] skip = new boolean[arr.length];

        for( int k=0; k<skip.length; k++){
            skip[k] = false;
        }

        for( int k=0; k< skip.length; k++){
            //remove if a multiple of n
            if((k+1) % n == 0)
                skip[k] = true;
        }
        int j=0;
        for (int i=0; i< arr.length; i++){
                if (skip[i] == true) {
                    if (maintainSpacing == true) {
                        removed[j++] = ' ';
                    }
                    else continue;
                }
                else
                    removed[j++] = arr[i];
            }

        char[] removedNthChar = new char[j];
        //shrink the final char[] to account for any chars removed, but not replaced with a blank
        for( int k=0; k<removedNthChar.length; k++){
            removedNthChar[k] = removed[k];
        }

        return new String(removedNthChar);
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        int count = count();
        //If the string has less than "endWord" words in it
        if(count < endWord)
            throw new IndexOutOfBoundsException();

        //if "startWord" <= 0, "endWord" <= 0, or "startWord"
        if(startWord <= 0 || endWord <= 0 || startWord > endWord)
            throw new IllegalArgumentException();

        List<String> result = null;
        if(_MyString != null && !_MyString.isEmpty()) {
            result = new Scanner(_MyString)
                    .useDelimiter(" ")
                    .tokens()
                    .collect(Collectors.toList());
        }

        String [] a = new String[result.size()];
        return result.subList(startWord-1,endWord).toArray(a);
    }

    @Override
    public String restoreString(int[] indices){
        //throws IllegalArgumentException if not s.length == indices.length == n
        if(_MyString.length() != indices.length )
            throw new IllegalArgumentException();

        //throws IndexOutOfBoundsException if   indices[i]< 0  or  indices[i]> string length
        for (int i=0; i < indices.length; i++) {
            if (indices[i] < 0 || indices[i] >= _MyString.length())
                throw new IndexOutOfBoundsException();
        }

        char[] origin = _MyString.toCharArray();
        char [] shuffled = new char[origin.length];

        for (int i=0; i < indices.length; i++){
            shuffled[i] = _MyString.charAt(indices[i]);
        }

        return new String(shuffled);
    }


}
