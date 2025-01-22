import java.util.Scanner;
public class Miles {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a kilometers");
        double kilometers=sc.nextDouble();
        double miles=kilometers*0.621371;
        System.out.println("Miles is "+miles);
    }
}
