import java.util.Scanner;

public class SumOfNaturalNumbers2 {

    public static int sumUsingRecursion(int n) {
        if (n==0) {
            return 0;
        }
        return n+sumUsingRecursion(n-1);
    }

    public static int sumUsingFormula(int n) {
        return (n*(n+1))/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n<=0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int sumRecursion = sumUsingRecursion(n);
        int sumFormula = sumUsingFormula(n);

        System.out.println("Sum of the first " + n + " natural numbers (using recursion): " + sumRecursion);
        System.out.println("Sum of the first " + n + " natural numbers (using formula): " + sumFormula);

        if (sumRecursion==sumFormula) {
            System.out.println("Both methods give the correct and same result.");
        } else {
            System.out.println("There is an error in the results.");
        }
    }
}
