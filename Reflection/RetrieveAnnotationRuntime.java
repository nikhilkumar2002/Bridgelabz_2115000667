import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {
}

public class RetrieveAnnotationRuntime {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}
