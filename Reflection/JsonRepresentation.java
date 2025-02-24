import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JsonRepresentation{
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        StringBuilder json = new StringBuilder("{");

        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": \"")
                    .append(fields[i].get(obj)).append("\"");

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Abhishek", 30);
        System.out.println(toJson(person));
    }
}
