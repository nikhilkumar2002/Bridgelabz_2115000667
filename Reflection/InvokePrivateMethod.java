import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod{
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        Class<?> cls = calculator.getClass();
        Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        int result = (int) multiplyMethod.invoke(calculator, 5, 6);

        System.out.println("Result of multiplication: " + result);
    }
}