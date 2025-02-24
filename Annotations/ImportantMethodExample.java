import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Apply the annotation to methods
class Application {

    @ImportantMethod
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void regularTask() {
        System.out.println("Executing regular task...");
    }

    public void nonImportantTask() {
        System.out.println("Executing non-important task...");
    }
}

// Step 3: Retrieve and print annotated methods using Reflection API
public class ImportantMethodExample {
    public static void main(String[] args) {
        Method[] methods = Application.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        // Execute methods
        Application app = new Application();
        app.criticalTask();
        app.regularTask();
    }
}
