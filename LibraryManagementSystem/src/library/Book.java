package library;

public class Book extends Libraryitem {
    // Additional attributes specific to Book
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        super(title, author);
        this.isAvailable = true;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    // Additional methods specific to Book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Borrowed successfully!");
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Returned successfully!");
    }

    @Override
    public String getItemInfo() {
        return super.getItemInfo() + "\nAvailability: " + isAvailable;
    }
}
