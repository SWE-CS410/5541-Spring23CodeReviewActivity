
/**
 * junit Assignment
 * kunga n ngochetsang
 * date 6/12/2023
 * */
public class StringManipulation implements StringManipulationInterface {
    private String stringData;
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
        int wordCount = 0;
        String[] stringArr;

        if(stringData!=null) {
            stringArr = stringData.trim().split("\\W+");
            wordCount = stringArr.length;

            if(wordCount==1&&stringArr[0].isEmpty()){
                wordCount=0;
            }
        }

        return wordCount;
    }

    @Override
    public String removeNthCharacter(int n, boolean maintainSpacing) {
        if(stringData==null){
            return null;
        }
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        if (n > stringData.length()) {
            throw new IllegalArgumentException("n must be less than the length of the string");
        }
        StringBuilder builtString = new StringBuilder(stringData);
        for (int i = n - 1; i < stringData.length(); i += n) {
            builtString.setCharAt(i, '~');
        }
        if(maintainSpacing){
            return builtString.toString().replace('~',' ');
        }else
            return builtString.toString().replace("~","");
    }

    @Override
    public String[] getSubStrings(int startWord, int endWord){
        if (startWord < 1||endWord<1||startWord>endWord) {
            throw new IllegalArgumentException("start word or end word is invalid");
        }
        if (endWord > stringData.trim().split("\\W+").length) {
            throw new IndexOutOfBoundsException("string has less than endWord words in it");
        }
        String[] stringArr;
        String[] stringArrSubString = new String[2];
        if(stringData!=null) {
            stringArr = stringData.trim().split("\\W+");
            stringArrSubString[0] = stringArr[startWord-1];
            stringArrSubString[1] =stringArr[endWord-1];
        }

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
        for (int i = 0; i<indices.length; i++){
            if (indices[i]< 0  ||  indices[i]> stringData.length()) {
                throw new IndexOutOfBoundsException("indices[i]< 0  or  indices[i]> string length");
            }
        }
       StringBuilder builtString = new StringBuilder();
        for (int i = 0;i<indices.length;i++){
            builtString.append(stringData.charAt(indices[i]));
        }
        return builtString.toString();
    }


}
