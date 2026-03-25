package model;

import java.time.LocalDate;

public class Loan {

    private String id;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(String id, Book book, Member member) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returned = false;
    }

    public void closeLoan() {
        this.returned = true;
        this.returnDate = LocalDate.now();
    }

    public boolean isActive() {
        return !returned;
    }

    public String getDetails() {
        return "Loan ID: " + id +
               ", Book: " + book.getTitle() +
               ", Member: " + member.getName() +
               ", Borrowed on: " + borrowDate +
               ", Returned: " + returned;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public boolean isReturned() {
        return returned;
    }
}