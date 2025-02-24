import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class DynamicallyObject{
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");

        Constructor<?> constructor = cls.getConstructor(String.class, int.class);
        Object student = constructor.newInstance("John", 20);

        Method displayMethod = cls.getMethod("display");
        ((Method) displayMethod).invoke(student);
    }
}