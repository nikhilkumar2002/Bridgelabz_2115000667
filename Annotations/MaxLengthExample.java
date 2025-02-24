import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value(); // Maximum allowed length
}

// Step 2: Apply the annotation to a field in the User class
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
        System.out.println("User created successfully: " + username);
    }

    // Step 3: Validate field length using Reflection
    private void validateMaxLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value() + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test the annotation
public class MaxLengthExample {
    public static void main(String[] args) {
        new User("JohnDoe");  // Valid
        new User("VeryLongUsername");  // Throws exception
    }
}