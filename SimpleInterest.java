import java.util.Scanner;
public class SimpleInterest {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a principal");
        double principal = sc.nextDouble();
        System.out.println("Enter a rate");
        double rate = sc.nextDouble();
        System.out.println("Enter a time in sec");
        double time = sc.nextDouble();
        double interest = (principal + rate + time) / 100;
        System.out.println("The Simple Interest is " + interest);
    }
}
