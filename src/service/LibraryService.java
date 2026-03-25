package service;
import model.Member;
import model.Book;
import java.util.List;

public interface LibraryService {

    
    void addBook(Book book);

    void removeBook(String bookId);

    List<Book> getAllBooks();

    Book searchBookById(String bookId);

    List<Book> searchBookByTitle(String title);

    // Loan management
    void borrowBook(String bookId, String memberId);

    void returnBook(String bookId, String memberId);
    void addMember(Member member);

    List<Member> getAllMembers();
}