package library;

public abstract class Libraryitem {
    // Attributes common to all library items
    private String title;
    private String author;

    // Constructor
    public Libraryitem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Abstract method to get the type of item
    public abstract String getItemType();

    // Method to get item info
    public String getItemInfo() {
        return "Title: " + title + "\nAuthor: " + author;
    }
}
