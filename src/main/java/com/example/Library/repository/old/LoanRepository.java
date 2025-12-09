package com.example.Library.repository.old;

import com.example.Library.model.Loan;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository extends InFileRepository<Loan> {
    public LoanRepository() {
        super("src/main/resources/data/loans.json", Loan.class);
    }
}
