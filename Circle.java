import java.util.Scanner;
//Define class
class CircleDetails{
    private double radius;
    public CircleDetails(){
        this(1.0);
    }
    //Constructor
    public CircleDetails(double radius){
        this.radius=radius;
    }
    // Method to display Circle details
    public void displayDetails(){
        System.out.println("Area of Circle: "+Math.PI*Math.pow(radius,2));
    }
}
//Main Class to Test
public class Circle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CircleDetails C1=new CircleDetails();
        System.out.println("\n-----Area of Circle with defalut Constructor-----");
        C1.displayDetails();
        System.out.println("Enter a number");
        double radius= sc.nextDouble();
        CircleDetails C2=new CircleDetails(radius);
        System.out.println("\n-----Area of Circle-----");
        C2.displayDetails();
    }
}
