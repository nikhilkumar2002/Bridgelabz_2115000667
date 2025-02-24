import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name(); // Custom JSON key
}

// Step 2: Apply @JsonField to a User class
class User2 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String ignoredField; // This field will not be serialized

    public User2(String username, int age, String ignoredField) {
        this.username = username;
        this.age = age;
        this.ignoredField = ignoredField;
    }
}

// Step 3: Convert object to JSON using Reflection API
class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }

        return jsonMap.toString().replace("=", ":"); // Convert to JSON-like format
    }
}

// Step 4: Test serialization
public class JsonSerializationExample {
    public static void main(String[] args) throws IllegalAccessException {
        User2 user = new User2("Alice", 25, "ThisWillBeIgnored");
        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}