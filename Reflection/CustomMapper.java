import java.lang.reflect.Field;
import java.util.Map;

class Persons {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }

        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of("name", "Alice", "age", 30);

        Persons person = toObject(Persons.class, properties);
        person.display();
    }
}
