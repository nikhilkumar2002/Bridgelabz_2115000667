import java.util.Scanner;
public class Volume {
    public static void main(String x[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a radius");
        double radius=sc.nextDouble();
        System.out.println("Enter a height");
        double height=sc.nextDouble();
        double volume=Math.PI*Math.pow(radius,2)*height;
        System.out.println("Volume is "+volume);
    }
}