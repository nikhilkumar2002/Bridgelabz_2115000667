import java.util.Scanner;
public class Temp {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a celsius");
        double celsius=sc.nextDouble();
        double fahrenheit=(celsius*9/5)+32;
        System.out.println("Fahrenheit is "+fahrenheit);
    }
}