class Book{
    String title;
    int publicationYear;

    public Book(String title,int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo(){
        System.out.println("Title of the Book: "+title);
        System.out.println("Publication Year of the Book: "+publicationYear);
    }
}

class Author extends Book{
    String name;
    String bio;

    public Author(String title,int publicationYear,String name,String bio){
        super(title,publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo(){
        System.out.println("Title of the Book: "+title);
        System.out.println("Publication Year of the Book: "+publicationYear);
        System.out.println("Author of the Book: "+name);
        System.out.println("Bio of the Book: "+bio);
    }
}

class LibraryManagement{
    public static void main(String[] args){
        Book book = new Author("Three Men In a Boat",2002,"Jerome K. Jerome","English writer and humorist.");
        book.displayInfo();
    }
}