import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethod{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperations = new MathOperations();

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        Class<?> cls = mathOperations.getClass();
        Method method = cls.getMethod(methodName, int.class, int.class);

        int result = (int) method.invoke(mathOperations, a, b);

        System.out.println("Result: " + result);
    }
}