import java.util.Scanner;
public class LeapYear2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("The year must be >=1582.");
        } else {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                System.out.println("(Single if) " + year + " is a Leap Year.");
            } else {
                System.out.println("(Single if) " + year + " is not a Leap Year.");
            }
        }
    }
}
