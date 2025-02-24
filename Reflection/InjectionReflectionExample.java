import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Consumer {
    @Inject
    private Service service;

    public void consume() {
        service.serve();
    }
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (!instances.containsKey(clazz)) {
            T instance = clazz.getDeclaredConstructor().newInstance();
            injectDependencies(instance);
            instances.put(clazz, instance);
            return instance;
        }
        return (T) instances.get(clazz);
    }

    private void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getInstance(field.getType());
                field.set(obj, dependency);
            }
        }
    }
}

public class InjectionReflectionExample {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        Consumer consumer = container.getInstance(Consumer.class);
        consumer.consume();
    }
}
