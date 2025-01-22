import java.util.Scanner;
public class PowerCalc {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base");
        double n1 = sc.nextDouble();
        System.out.println("Enter the exponent");
        double n2 = sc.nextDouble();
        double result = Math.pow(n1,n2);
        System.out.println(n1+ " raised to the power of " +n2+ " is " +result);
    }
}
