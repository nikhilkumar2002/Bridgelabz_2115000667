class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search movie by director or rating
    public void searchByDirectorOrRating(String director, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Update movie rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies forward
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        list.addAtBeginning("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        list.addAtEnd("Dangal", "Nitesh Tiwari", 2016, 8.3);
        list.addAtEnd("PK", "Rajkumar Hirani", 2014, 8.1);
        list.addAtPosition(2, "Zindagi Na Milegi Dobara", "Zoya Akhtar", 2011, 8.2);

        System.out.println("All Movies (Forward):");
        list.displayForward();

        System.out.println("\nAll Movies (Reverse):");
        list.displayReverse();

        System.out.println("\nSearching for movies directed by Rajkumar Hirani:");
        list.searchByDirectorOrRating("Rajkumar Hirani", -1);

        System.out.println("\nUpdating rating for PK:");
        list.updateRating("PK", 8.5);
        list.displayForward();

        System.out.println("\nDeleting movie Dangal:");
        list.removeByTitle("Dangal");
        list.displayForward();
    }
}
