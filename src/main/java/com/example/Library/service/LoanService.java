package com.example.Library.service;

import com.example.Library.model.Loan;
import com.example.Library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void add(Loan loan) {
        loanRepository.save(loan);
    }

    public void update(Loan loan) {
        loanRepository.update(loan);
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    public Loan getById(String id) {
        return loanRepository.findById(id);
    }

    public void delete(String id) {
        loanRepository.delete(id);
    }
}
