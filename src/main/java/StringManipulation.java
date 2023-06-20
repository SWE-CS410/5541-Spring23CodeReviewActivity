import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
/**
 * junit Assignment
 * kunga n ngochetsang
 * date 6/12/2023
 * */
public class StringManipulation implements StringManipulationInterface {
    private String stringData ="";
    @Override
    public String getString() {
        return stringData;
    }

    @Override
    public void setString(String string) {
        stringData = string;
    }

    @Override
    public int count() {
        if(stringData == null) {
            throw new NullPointerException("String is null.");
        }
        int wordCount = 0;
        String[] stringArr;

        stringArr = stringData.trim().split("[^a-zA-Z0-9_'@&-]+");
        wordCount = stringArr.length;

        if(wordCount==1&&stringArr[0].isEmpty()){
            wordCount=0;
        }
        return wordCount;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if(stringData==null){
            throw new NullPointerException("String is null.");
        }
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        if (n > stringData.length()) {
            throw new IllegalArgumentException("n must be less than the length of the string");
        }
        StringBuilder builtString = new StringBuilder(stringData);
        for (int i = n - 1; i < stringData.length(); i += n) {
            builtString.setCharAt(i, '|');
        }
        if(maintainSpacing){
            return builtString.toString().replace("|"," ");
        }else
            return builtString.toString().replace("|","");
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord < 1||endWord<1||startWord>endWord) {
            throw new IllegalArgumentException("start word or end word is invalid");
        }
        if (endWord > count()) {
            throw new IndexOutOfBoundsException("string has less than endWord words in it");
        }
        String[] stringArr;
        stringArr = stringData.trim().split("[^a-zA-Z0-9_'@&]+");
        String[] stringArrSubString = Arrays.copyOfRange(stringArr,startWord-1,endWord);
        return stringArrSubString;
    }

    @Override
    public String restoreString(int[] indices){
        if (stringData ==null){
            return null;
        }
        if (stringData.length() != indices.length) {
            throw new IllegalArgumentException("not s.length == indices.length == n");
        }
       StringBuilder builtString = new StringBuilder();
        for (int i = 0;i<indices.length;i++){
            if (indices[i]< 0  ||  indices[i]> stringData.length()) {
                throw new IndexOutOfBoundsException("indices[i]< 0  or  indices[i]> string length");
            }
            builtString.append(stringData.charAt(indices[i]));
        }
        return builtString.toString();
    }


}
