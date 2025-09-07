package model;

public class Book {
    private String code;
    private String title;
    private String author;
    private int stock;

    public Book(String code, String title, String author, int stock) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }
}
