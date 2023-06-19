public interface StringManipulationInterface {
    // Method to set the string
    void setString(String s);

    // Method to count the number of words in the string
    int count();

    // Method to remove the nth character from the string, considering spaces as well or not
    String removeNthCharacter(int n, boolean considerSpaces);

    // Method to get an array of substrings of the string, from start to end (both inclusive)
    String[] getSubStrings(int start, int end);

    // Method to restore the string by the provided array
    String restoreString(int[] array);
}