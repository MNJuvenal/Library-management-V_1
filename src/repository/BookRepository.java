package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    // Attributes
    private List<Book> books;

    // Constructor
    public BookRepository() {
        this.books=new ArrayList<>();
    }

    // Methods

    public void save(Book book) {
        books.add(book);
    }

    public void delete(String bookId) {
        if (books.isEmpty()) {
            throw new RuntimeException("the bookRepository is already empty");
        }
        books.removeIf(b -> b.getId().equals(bookId));
    }

    public Book findById(String id) {

        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        // not found
        return null;
    }


    public List<Book> findAll() {
        // return a copy to avoid exposing internal list
        return new ArrayList<>(this.books);
    }

    public List<Book> findByTitle(String title) {

        List<Book> results = new ArrayList<>();
        for (Book b : this.books) {
            if (b.getTitle().equals(title)) {
                results.add(b);
            }
        }
        if (results.isEmpty()) {
            System.out.println("no book found with this title ");
        }
        return results;
    }
}