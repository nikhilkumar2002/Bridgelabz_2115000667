import java.util.Scanner;
public class SumToZero{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double total=0.0;
        double number;
        System.out.println("Enter a number (0 to stop):");
        number=sc.nextDouble();
        while(number!=0){
            total+=number;
            System.out.println("Enter a number (0 to stop):");
            number=sc.nextDouble();
        }
        System.out.println("Total sum: "+total);
    }
}