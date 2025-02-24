import java.lang.reflect.*;

import java.util.*;

public class GetClassInformation{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        Class<?> cls = Class.forName(className);

        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
    }
}
