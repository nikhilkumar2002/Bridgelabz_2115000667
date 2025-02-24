import java.lang.reflect.Method;

class ExampleClass {
    public void fastMethod() {
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void slowMethod() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        ExampleClass example = new ExampleClass();
        Class<?> cls = example.getClass();

        Method fastMethod = cls.getMethod("fastMethod");
        Method slowMethod = cls.getMethod("slowMethod");

        measureExecutionTime(example, fastMethod);
        measureExecutionTime(example, slowMethod);
    }

    public static void measureExecutionTime(Object obj, Method method) throws Exception {
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Execution time of " + method.getName() + ": " + duration / 1_000_000 + " ms");
    }
}
