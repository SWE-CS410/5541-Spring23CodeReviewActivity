import java.util.*;

public class StringManipulation implements StringManipulationInterface {
    private String s;

    @Override
    public void setString(String s) {
        this.s = s;
    }

    @Override
    public int count() {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }

    @Override
    public String removeNthCharacter(int n, boolean includeSpaces) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((includeSpaces && c != ' ') || !includeSpaces) {
                if ((i + 1) % n != 0) {
                    result.append(c);
                } else if (includeSpaces) {
                    result.append(' ');
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }


    @Override
    public String[] getSubStrings(int start, int end) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        String[] words = s.split("\\s+");
        if (start < 0 || end > words.length || start > end) {
            return new String[0];
        }
        return Arrays.copyOfRange(words, start, end+1);
    }

    @Override
    public String restoreString(int[] array) {
        if (s == null || array == null) {
            return s;
        }
        char[] arr = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < arr.length) {
                arr[array[i]] = s.charAt(i);
            }
        }
        return new String(arr);
    }
}
