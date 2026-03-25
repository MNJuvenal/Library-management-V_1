package model;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private int maxBooksAllowed = 3;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public String  getDetails() {
        return "Member details: " + toString();
    }

    public String  borrowBook(Book b) {
        if (borrowedBooks.size() < maxBooksAllowed) {
            borrowedBooks.add(b);
            return "You've borrowed: " + b.getTitle() + " written by " + b.getAuthor();
        } else {
            return "You can't borrow more books. Return a book before borrowing another.";
        }
    }

    public String returnBook(Book b) {
        if (borrowedBooks.remove(b)) {
            return "You've returned: " + b.getTitle() + " written by " + b.getAuthor();
        } else {
            return "This book was not borrowed by the member.";
        }
    }

    public List<Book> getBorrowedBooks() {
        
        return borrowedBooks;
    }

    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }

}