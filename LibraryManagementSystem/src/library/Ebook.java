package library;

public class Ebook extends Book {
    private double fileSize;
    private String format;

    public Ebook(String title, String author, double fileSize, String format) {
        super(title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public String getItemType() {
        return "EBook";
    }

    @Override
    public String getItemInfo() {
        return super.getItemInfo() + "\nFile Size: " + fileSize + " MB\nFormat: " + format;
    }
}
