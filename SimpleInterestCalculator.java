import java.util.Scanner;
public class SimpleInterestCalculator {
    public static double calculateSimpleInterest(double principal,double rate,double time) {
        return (principal*rate*time)/100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal amount: ");
        double principal = sc.nextDouble();
        System.out.println("Enter the Rate of Interest: ");
        double rate = sc.nextDouble();
        System.out.println("Enter the Time (in years): ");
        double time = sc.nextDouble();
        double simpleInterest = calculateSimpleInterest(principal,rate,time);
        System.out.println("The Simple Interest is"+simpleInterest+"for Principal"+principal+
                ",Rate of Interest"+rate+",and Time"+time+"years.");
    }
}
