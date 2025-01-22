import java.util.Scanner;
public class Perimeter {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length");
        double length = sc.nextDouble();
        System.out.println("Enter a width");
        double width = sc.nextDouble();
        double perimeter=2*(length+width);
        System.out.println("Perimeter is "+perimeter);
    }
}
