import java.util.Scanner;

public class NumberChecker {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static String isEven(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    public static int compare(int number1, int number2) {
        if(number1>number2){
            return 1;
        }else if(number1==number2){
            return 0;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        for(int i=0;i<5;i++){
            System.out.print("Enter number "+(i+1)+": ");
            numbers[i] = sc.nextInt();
        }

        for(int i=0;i<numbers.length;i++){
            if(isPositive(numbers[i])){
                System.out.println(numbers[i]+" is positive and "+isEven(numbers[i])+".");
            }else{
                System.out.println(numbers[i]+" is negative.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[4]);
        if(comparisonResult==1){
            System.out.println("The first number is greater than the last number.");
        }else if(comparisonResult==0){
            System.out.println("The first number is equal to the last number.");
        }else{
            System.out.println("The first number is less than the last number.");
        }
    }
}
