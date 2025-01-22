import java.util.Scanner;
public class TemperatureConversion {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       // Input temperature in Celsius
       System.out.print("Enter the temperature in Celsius: ");
       double celsius = scanner.nextDouble();
       // Convert Celsius to Fahrenheit
       double fahrenheit = (celsius * 9 / 5) + 32;
       // Output result
       System.out.println("The " + celsius + " Celsius is " + fahrenheit + " Fahrenheit.");

   }
