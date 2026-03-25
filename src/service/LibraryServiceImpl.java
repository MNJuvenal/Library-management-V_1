package service;

import model.Book;
import model.Loan;
import model.Member;
import repository.BookRepository;
import repository.MemberRepository;
import repository.LoanRepository;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LoanRepository loanRepository;

    public LibraryServiceImpl() {
        this.bookRepository= new BookRepository();
        this.memberRepository=new MemberRepository() ;
        this.loanRepository= new LoanRepository();


    }

    @Override
    public void addBook(Book book) {
        if(bookRepository.findById(book.getId())==null){
            bookRepository.save(book);

        }
    }

    @Override
    public void removeBook(String bookId) {
        if(bookRepository.findById(bookId)!=null){
            bookRepository.delete(bookId);

        }

    }

    @Override
    public List<Book> getAllBooks() {
        // always return a (possibly empty) list from the repository
        return bookRepository.findAll();
    }

    @Override
    public Book searchBookById(String bookId) {
        if(bookRepository!=null){

            return bookRepository.findById(bookId)  ;

        }

        return null;
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        if(bookRepository!=null){

            return bookRepository.findByTitle(title)  ;

        }

        return null;
    }
@Override
public void borrowBook(String bookId, String memberId) {
    Book book = bookRepository.findById(bookId);
    if (book == null) {
        throw new RuntimeException("Book not found");
    }

    Member member = memberRepository.findById(memberId);
    if (member == null) {
        throw new RuntimeException("Member not found");
    }

    if (!book.isAvailable()) {
        throw new RuntimeException("Book is not available");
    }

    Loan activeLoan = loanRepository.findActiveLoanByBookId(bookId);
    if (activeLoan != null) {
        throw new RuntimeException("This book is already borrowed");
    }

    String loanId = "LN-" + System.currentTimeMillis();
    Loan loan = new Loan(loanId, book, member);

    loanRepository.save(loan);
    book.markAsBorrowed();
    member.borrowBook(book);
}
        
    @Override
public void returnBook(String bookId, String memberId) {
    Book book = bookRepository.findById(bookId);
    if (book == null) {
        throw new RuntimeException("Book not found");
    }

    Member member = memberRepository.findById(memberId);
    if (member == null) {
        throw new RuntimeException("Member not found");
    }

    Loan activeLoan = loanRepository.findActiveLoanByBookId(bookId);
    if (activeLoan == null) {
        throw new RuntimeException("No active loan found for this book");
    }

    if (!activeLoan.getMember().getId().equals(memberId)) {
        throw new RuntimeException("This member did not borrow the book");
    }

    activeLoan.closeLoan();
    book.markAsAvailable();
    member.returnBook(book);
}
@Override
public void addMember(Member member) {
    memberRepository.save(member);
}

@Override
public List<Member> getAllMembers() {
    return memberRepository.findAll();
}

}