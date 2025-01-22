import java.util.Scanner;
public class Area {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a radius");
        double radius=sc.nextDouble();
        double area=Math.PI*Math.pow(radius,2);
        System.out.println("Area is "+area);
    }
}
