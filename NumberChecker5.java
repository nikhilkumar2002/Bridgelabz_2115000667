public class NumberChecker5 {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    public static boolean isSpyNumber(int number) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        while (number > 0) {
            int digit = number % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            number /= 10;
        }
        return sumOfDigits == productOfDigits;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numStr);
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        int number = 7;

        boolean isPrime = isPrime(number);
        System.out.println("Is Prime Number: " + isPrime);

        boolean isNeon = isNeonNumber(number);
        System.out.println("Is Neon Number: " + isNeon);

        boolean isSpy = isSpyNumber(number);
        System.out.println("Is Spy Number: " + isSpy);

        boolean isAutomorphic = isAutomorphicNumber(number);
        System.out.println("Is Automorphic Number: " + isAutomorphic);

        boolean isBuzz = isBuzzNumber(number);
        System.out.println("Is Buzz Number: " + isBuzz);
    }
}
