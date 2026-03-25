package repository;

import model.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    private List<Loan> loans;

    public LoanRepository() {
        this.loans = new ArrayList<>();
    }
    public void save(Loan loan) {
        loans.add(loan);
    }

    public Loan findById(String id) {

        for(Loan l :loans){
            if(l.getId().equals(id)){
                return l;
            }
        }
        return null;
    }

    public List<Loan> findAll() {
        return new ArrayList<>(this.loans);
    }

    public Loan findActiveLoanByBookId(String bookId) {
        for (Loan l : loans) {
            if (l.getBook() != null && l.getBook().getId().equals(bookId) && l.isActive()) {
                return l;
            }
        }
        return null;
    }
}