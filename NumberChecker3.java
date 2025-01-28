public class NumberChecker3 {

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

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int findSumOfSquaresOfDigits(int[] digits) {
        int sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }

    public static boolean isHarshadNumber(int number) {
        int[] digits = storeDigitsInArray(number);
        int sumOfDigits = findSumOfDigits(digits);
        return number % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequency(int number) {
        int[] frequency = new int[10];
        int[] digits = storeDigitsInArray(number);

        for (int digit : digits) {
            frequency[digit]++;
        }

        int[][] digitFrequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            digitFrequency[i][0] = i;
            digitFrequency[i][1] = frequency[i];
        }
        return digitFrequency;
    }

    public static void main(String[] args) {
        int number = 1729;

        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        int[] digits = storeDigitsInArray(number);
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        int sumOfDigits = findSumOfDigits(digits);
        System.out.println("Sum of digits: " + sumOfDigits);

        int sumOfSquares = findSumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad Number: " + isHarshad);

        int[][] digitFrequency = findDigitFrequency(number);
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (digitFrequency[i][1] > 0) {
                System.out.println("Digit: " + digitFrequency[i][0] + ", Frequency: " + digitFrequency[i][1]);
            }
        }
    }
}
