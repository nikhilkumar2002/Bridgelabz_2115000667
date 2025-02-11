class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeByBookId(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchByTitleOrAuthor(String title, String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)) {
                System.out.println("Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Book ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Book ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Book ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Classic", 103, false);
        library.addAtPosition(2, "Moby Dick", "Herman Melville", "Adventure", 104, true);

        System.out.println("All Books (Forward):");
        library.displayForward();

        System.out.println("\nAll Books (Reverse):");
        library.displayReverse();

        System.out.println("\nSearching for books by George Orwell:");
        library.searchByTitleOrAuthor("", "George Orwell");

        System.out.println("\nUpdating Availability for Book ID 103:");
        library.updateAvailability(103, true);
        library.displayForward();

        System.out.println("\nTotal number of books in the library:");
        System.out.println(library.countBooks());

        System.out.println("\nRemoving book '1984':");
        library.removeByBookId(102);
        library.displayForward();
    }
}