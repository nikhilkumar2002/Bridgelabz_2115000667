import java.util.Scanner;
public class MultiplicationTable2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number=sc.nextInt();
        int[] multiplicationResult=new int[4];
        for(int i=6;i<=9;i++)multiplicationResult[i-6]=number*i;
        System.out.println("Multiplication Table for "+number+" from 6 to 9:");
        for(int i=6;i<=9;i++)System.out.println(number+" * "+i+" = "+multiplicationResult[i-6]);
    }
}