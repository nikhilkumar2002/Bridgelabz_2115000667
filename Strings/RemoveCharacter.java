public class RemoveCharacter {
    public static void main(String[] args) {
        String inputString = "Hello World";  // Original String
        char charToRemove = 'l';  // Character to remove

        // Convert the character to a string and use replaceAll to remove it
        String modifiedString = inputString.replaceAll(String.valueOf(charToRemove), "");

        // Output the modified string
        System.out.println("Modified String: " + modifiedString);
    }
}