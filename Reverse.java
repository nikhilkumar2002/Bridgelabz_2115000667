import java.util.Scanner;
public class Reverse{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number=sc.nextInt();
        int count=0;
        int temp=number;
        while(temp!=0){
            temp/=10;
            count++;
        }
        int[] digits=new int[count];
        temp=number;
        for(int i=0;i<count;i++){
            digits[i]=temp%10;
            temp/=10;
        }
        System.out.println("Reversed number:");
        for(int i=0;i<count;i++){
            System.out.print(digits[i]);
        }
    }
}