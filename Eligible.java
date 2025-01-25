import java.util.Scanner;
public class Eligible{
    public static void main(String[] args){
        int[] ages=new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ages of 10 students:");
        for(int i=0;i<ages.length;i++){
            System.out.println("Enter age for student "+(i+1)+":");
            ages[i]=sc.nextInt();
        }
        for(int age:ages){
            if(age<0)System.out.println("Invalid age: "+age);
            else if(age>=18)System.out.println("The student with the age "+age+" can vote.");
            else System.out.println("The student with the age "+age+" cannot vote.");
        }
    }
}