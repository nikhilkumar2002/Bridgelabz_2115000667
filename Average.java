import java.util.Scanner;
public class Average {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no.");
        double n1 = sc.nextDouble();
        System.out.println("Enter a no.");
        double n2 = sc.nextDouble();
        System.out.println("Enter a no.");
        double n3 = sc.nextDouble();
        System.out.println("Average is "+(n1+n2+n3)/3);
    }
}
