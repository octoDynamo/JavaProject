package library;

public class Book {
    // Private Attributes
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // The book is available when created
    }

    // Public Methods

    // Borrow the book if available
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Borrowed successfully!");
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    // Return the book
    public void returnBook() {
        isAvailable = true;
        System.out.println("Returned successfully!");
    }

    // Get book information
    public String getBookInfo() {
        return "Book Title: \"" + title + "\"\nAuthor: \"" + author + "\"\nAvailability: " + isAvailable;
    }
}
