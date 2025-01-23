import java.util.Scanner;
public class Grade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter marks in Physics");
        int physics=sc.nextInt();
        System.out.println("Enter marks in Chemistry");
        int chemistry=sc.nextInt();
        System.out.println("Enter marks in Maths");
        int maths=sc.nextInt();
        double percentage=(physics+chemistry+maths)/3.0;
        System.out.println("Percentage: "+percentage);
        if(percentage>=80) {
            System.out.println("Grade: A");
        }
        else if(percentage>=70) {
            System.out.println("Grade: B");
        }
        else if(percentage>=60) {
            System.out.println("Grade: C");
        }
        else if(percentage>=50) {
            System.out.println("Grade: D");
        }
        else if(percentage>=40) {
            System.out.println("Grade: E");
        }
        else {
            System.out.println("Grade: R");
        }
    }
}