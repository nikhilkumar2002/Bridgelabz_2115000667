public class NumberChecker6 {

    public static int[] findFactors(int number) {
        ArrayList<Integer> factorList = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                factorList.add(i);
                if (i != number / i) {
                    factorList.add(number / i);
                }
            }
        }
        return factorList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int findGreatestFactor(int[] factors) {
        int greatest = Integer.MIN_VALUE;
        for (int factor : factors) {
            greatest = Math.max(greatest, factor);
        }
        return greatest;
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int findProductOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }

        return sum == originalNumber;
    }

    private static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 28; // Example number

        int[] factors = findFactors(number);
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        int greatestFactor = findGreatestFactor(factors);
        System.out.println("Greatest Factor: " + greatestFactor);

        int sumOfFactors = findSumOfFactors(factors);
        System.out.println("Sum of Factors: " + sumOfFactors);

        int productOfFactors = findProductOfFactors(factors);
        System.out.println("Product of Factors: " + productOfFactors);

        double productOfCubes = findProductOfCubes(factors);
        System.out.println("Product of Cube of Factors: " + productOfCubes);

        boolean isPerfect = isPerfectNumber(number);
        System.out.println("Is Perfect Number: " + isPerfect);

        boolean isAbundant = isAbundantNumber(number);
        System.out.println("Is Abundant Number: " + isAbundant);

        boolean isDeficient = isDeficientNumber(number);
        System.out.println("Is Deficient Number: " + isDeficient);

        boolean isStrong = isStrongNumber(number);
        System.out.println("Is Strong Number: " + isStrong);
    }
}
