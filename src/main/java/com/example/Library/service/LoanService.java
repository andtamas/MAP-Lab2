package com.example.Library.service;

import com.example.Library.model.Loan;
import com.example.Library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        loanRepository.save(loan);
    }

    public List<Loan> getAll() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getById(Long id) {
        return loanRepository.findById(id);
    }

    public void delete(Long id) {
        loanRepository.deleteById(id);
    }
}
