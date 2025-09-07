package model;

import util.Config;

public class Catalog {
    private Book[] books;
    private int numberOfBooks;

    public Catalog() {
        this.books = new Book[Config.MAX_SIZE_CATALOG];
        this.numberOfBooks = 0;
    }

    public boolean addBook(Book book) {
        if (numberOfBooks < Config.MAX_SIZE_CATALOG) {
            books[numberOfBooks] = book;
            numberOfBooks++;
            return true;
        }
        return false;
    }
}
