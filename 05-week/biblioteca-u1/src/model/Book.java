package model;

public class Book {
    private String code;
    private String title;
    private String autor;
    private int stock;

    public Book(String code, String title, String autor, int stock) {
        this.code = code;
        this.title = title;
        this.autor = autor;
        this.stock = stock;
    }
}
