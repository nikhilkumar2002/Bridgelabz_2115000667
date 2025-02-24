import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Create a container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Apply the annotation multiple times on a method
class SoftwareModule {
    @BugReport(description = "Null pointer exception occurs on edge cases.")
    @BugReport(description = "Performance issue when processing large data.")
    public void process() {
        System.out.println("Processing...");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection API
public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }

        // Call the method
        SoftwareModule module = new SoftwareModule();
        module.process();
    }
}
