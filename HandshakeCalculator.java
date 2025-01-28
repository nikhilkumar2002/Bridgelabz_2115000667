import java.util.Scanner;
public class HandshakeCalculator {
    public static int calculateHandshakes(int n) {
        return(n*(n-1))/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        int handshakes = calculateHandshakes(n);
        System.out.println("The maximum number of handshakes among " + n + " students is: " + handshakes);
    }
}