import java.util.Scanner;

// Base class: Publisher
class Publisher {
    String publisherName;

    Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    void displayPublisher() {
        System.out.println("Publisher: " + publisherName);
    }
}

// Derived class: Book (inherits from Publisher)
class Book extends Publisher {
    String bookTitle;
    String author;

    Book(String publisherName, String bookTitle, String author) {
        super(publisherName);
        this.bookTitle = bookTitle;
        this.author = author;
    }

    void displayBook() {
        displayPublisher();
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + author);
    }
}

// Subclass: Literature (inherits from Book)
class Literature extends Book {
    String genre = "Literature";

    Literature(String publisherName, String bookTitle, String author) {
        super(publisherName, bookTitle, author);
    }

    void displayDetails() {
        displayBook();
        System.out.println("Genre: " + genre);
    }
}

// Subclass: Fiction (inherits from Book)
class Fiction extends Book {
    String genre = "Fiction";

    Fiction(String publisherName, String bookTitle, String author) {
        super(publisherName, bookTitle, author);
    }

    void displayDetails() {
        displayBook();
        System.out.println("Genre: " + genre);
    }
}

// Main class
public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for Literature book
        System.out.println("Enter Literature Book Details:");
        System.out.print("Publisher: ");
        String pub1 = scanner.nextLine();
        System.out.print("Book Title: ");
        String title1 = scanner.nextLine();
        System.out.print("Author: ");
        String author1 = scanner.nextLine();
        Literature literatureBook = new Literature(pub1, title1, author1);

        // Taking input for Fiction book
        System.out.println("\nEnter Fiction Book Details:");
        System.out.print("Publisher: ");
        String pub2 = scanner.nextLine();
        System.out.print("Book Title: ");
        String title2 = scanner.nextLine();
        System.out.print("Author: ");
        String author2 = scanner.nextLine();
        Fiction fictionBook = new Fiction(pub2, title2, author2);

        // Display book details
        System.out.println("\n--- Literature Book Details ---");
        literatureBook.displayDetails();

        System.out.println("\n--- Fiction Book Details ---");
        fictionBook.displayDetails();

        scanner.close();
    }
}
