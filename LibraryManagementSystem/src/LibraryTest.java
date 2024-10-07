import library.Book;

public class LibraryTest {
    public static void main(String[] args) {
        // Create an instance of Book
        Book myBook = new Book("Java Programming", "John Doe");

        // Display book info
        System.out.println(myBook.getBookInfo());

        // Borrow the book
        System.out.println("Borrowing the book...");
        myBook.borrowBook();

        // Display book info after borrowing
        System.out.println(myBook.getBookInfo());

        // Return the book
        System.out.println("Returning the book...");
        myBook.returnBook();

        // Display book info after returning
        System.out.println(myBook.getBookInfo());
    }
}
