import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double first, second;
        String op;
        System.out.println("Enter first number: ");
        first=sc.nextDouble();
        System.out.println("Enter operator (+, -, *, /): ");
        op=sc.next();
        System.out.println("Enter second number: ");
        second=sc.nextDouble();

        switch(op){
            case"+":
                System.out.println("Result: "+(first+second));
                break;
            case"-":
                System.out.println("Result: "+(first-second));
                break;
            case"*":
                System.out.println("Result: "+(first*second));
                break;
            case"/":
                if(second!=0){
                    System.out.println("Result: "+(first/second));
                }
                else{
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
                break;
        }
    }
}