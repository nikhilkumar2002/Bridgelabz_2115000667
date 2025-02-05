import java.util.ArrayList;

// Book class with attributes: title and author
class Book {
    String title;
    String author;

    // Constructor to initialize Book attributes
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

// Library class that aggregates Book objects using an ArrayList
public class Library {
    ArrayList<Book> books;

    // Constructor to initialize the ArrayList of books
    Library() {
        books = new ArrayList<>();
    }

    // Method to add a Book to the library
    void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author);
        }
    }

    // Main method to demonstrate the aggregation relationship
    public static void main(String[] args) {
        // Create Book objects
        Book b1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book b2 = new Book("Pride and Prejudice", "Jane Austen");
        Book b3 = new Book("The Lord of the Rings", "J.R.R. Tolkien");

        // Create two Library objects
        Library lib1 = new Library();
        Library lib2 = new Library();

        // Add books to the first library
        lib1.addBook(b1);
        lib1.addBook(b2);

        // Add books to the second library
        // Notice that b2 is added to both libraries, demonstrating aggregation
        lib2.addBook(b2);
        lib2.addBook(b3);

        // Display books in Library 1
        System.out.println("Library 1 Books:");
        lib1.displayBooks();

        // Display books in Library 2
        System.out.println("\nLibrary 2 Books:");
        lib2.displayBooks();
    }
}
