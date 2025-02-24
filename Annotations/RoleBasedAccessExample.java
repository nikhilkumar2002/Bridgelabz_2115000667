import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value(); // Role required to access the method
}

// Step 2: Simulate user roles
class UserSession {
    private String role;

    public UserSession(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Apply @RoleAllowed to a restricted method
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }
}

// Step 4: Validate user role before executing the method
public class RoleBasedAccessExample {
    public static void main(String[] args) throws Exception {
        UserSession user = new UserSession("USER");  // Change to "ADMIN" to allow access
        SecureService service = new SecureService();

        Method method = SecureService.class.getMethod("adminTask");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (user.getRole().equals(roleAllowed.value())) {
                method.invoke(service); // Execute method if role matches
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
