import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int numberOfChocolates,int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates/numberOfChildren;
        int remainingChocolates = numberOfChocolates%numberOfChildren;
        return new int[]{chocolatesPerChild,remainingChocolates};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates,numberOfChildren);

        System.out.println("Each child will get " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
