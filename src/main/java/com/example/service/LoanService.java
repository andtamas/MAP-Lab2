package com.example.service;

import com.example.model.Loan;
import com.example.repository.LoanRepository;
import java.util.List;

public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = new LoanRepository();
    }

    public void add(Loan loan) {
        loanRepository.add(loan);
    }

    public void update(Loan loan) {
        loanRepository.update(loan);
    }

    public List<Loan> getAll() {
        return loanRepository.getList();
    }

    public Loan getById(String id) {
        return loanRepository.findById(id);
    }

    public boolean delete(String id) {
        return loanRepository.delete(id);
    }

    public Loan getByMemberId(String id) {
        return loanRepository.getByMemberId(id);
    }
}
