import java.util.Scanner;

public class FactorCalculator {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i<=number; i++) {
            if (number%i==0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i<=number; i++) {
            if (number%i==0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum+=factor;
        }
        return sum;
    }

    public static int findProduct(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product*=factor;
        }
        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares+=Math.pow(factor,2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors of " + number + " are: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        int sum = findSum(factors);
        int product = findProduct(factors);
        double sumOfSquares = findSumOfSquares(factors);

        System.out.println("Sum of the factors: " + sum);
        System.out.println("Product of the factors: " + product);
        System.out.println("Sum of the square of the factors: " + sumOfSquares);
    }
}
