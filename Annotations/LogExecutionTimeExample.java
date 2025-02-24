import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

// Step 2: Apply the annotation to methods
class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
        for (int i = 0; i < 1000; i++); // Simulating work
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        for (int i = 0; i < 1_000_000; i++); // Simulating heavy work
    }
}

// Step 3: Measure execution time using Reflection API
public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;
                System.out.println("Execution Time of " + method.getName() + ": " + executionTime + " ns");
                System.out.println("---------------------------------");
            }
        }
    }
}
