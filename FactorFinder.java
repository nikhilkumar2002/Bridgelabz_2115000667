import java.util.Scanner;
public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number to find its factors: ");
        int number=scanner.nextInt();
        System.out.println("The factors of "+number+" are:");
        for(int i=1;i<=number;i++){
            if(number%i==0){
                System.out.println(i);
            }
        }
    }
}