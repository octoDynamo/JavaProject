import library.*;

class LibraryTest {
    public static void main(String[] args) {
        // Create an instance of Book
        Libraryitem myBook = new Book("Java Programming", "John Doe");

        // Create an instance of EBook
        Libraryitem myEBook = new Ebook("Advanced Java", "Jane Smith", 5.5, "PDF");

        // Demonstrate polymorphism
        System.out.println("Book Info:");
        System.out.println(myBook.getItemInfo());

        System.out.println("\nEBook Info:");
        System.out.println(myEBook.getItemInfo());
    }
}
