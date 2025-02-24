import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "default_key";
}

public class StaticField {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Configuration.class;
        Field apiKeyField = cls.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);

        System.out.println("Initial API_KEY: " + apiKeyField.get(null));

        apiKeyField.set(null, "new_api_key");

        System.out.println("Updated API_KEY: " + apiKeyField.get(null));
    }
}
