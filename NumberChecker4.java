public class NumberChecker4 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] storeDigitsInArray(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = storeDigitsInArray(number);
        int[] reversedDigits = reverseArray(digits);
        return compareArrays(digits, reversedDigits);
    }

    public static boolean isDuckNumber(int number) {
        String numStr = String.valueOf(number);
        return numStr.contains("0") && !numStr.startsWith("0");
    }

    public static void main(String[] args) {
        int number = 1221;

        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digits = storeDigitsInArray(number);
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        int[] reversedDigits = reverseArray(digits);
        System.out.print("Reversed Digits: ");
        for (int digit : reversedDigits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        boolean isPalindrome = isPalindrome(number);
        System.out.println("Is Palindrome: " + isPalindrome);

        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck Number: " + isDuck);
    }
}
