import java.lang.reflect.Field;

class Personss {
    private int age;

    public Personss(int age) {
        this.age = age;
    }
}

public class AccessPrivateField{
    public static void main(String[] args) throws Exception {
        Personss person = new Personss(25);

        Class<?> cls = person.getClass();
        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Initial Age: " + ageField.get(person));

        ageField.set(person, 30);

        System.out.println("Updated Age: " + ageField.get(person));
    }
}