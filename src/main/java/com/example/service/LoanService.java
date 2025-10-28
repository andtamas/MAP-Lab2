package com.example.service;

import com.example.model.Loan;
import com.example.repository.LoanRepository;
import java.util.List;

public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = new LoanRepository();
    }

    public void addLoan(Loan loan) {
        loanRepository.add(loan);
    }

    public void updateLoan(Loan loan) {
        loanRepository.update(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.getList();
    }

    public Loan getLoanById(String id) {
        return loanRepository.findById(id);
    }

    public boolean deleteLoan(String id) {
        return loanRepository.delete(id);
    }

    public Loan getLoanByMemberId(String id) {
        return loanRepository.getByMemberId(id);
    }
}
