package com.example.repository;

import com.example.model.Loan;

import java.util.List;
import java.util.ArrayList;

public class LoanRepository {
    private List<Loan> loanList;

    public LoanRepository() {
        loanList = new ArrayList<>();
    }

    public void save(Loan loan) {
        for (int i=0; i<loanList.size(); i++) {
            if (loanList.get(i).getId().equals(loan.getId())) {
                loanList.set(i, loan);
            }
        }
        loanList.add(loan);
    }

    public List<Loan> getList() {
        return loanList;
    }

    public Loan findById(String id) {
        for (int i = 0; i<loanList.size(); i++) {
            if (loanList.get(i).getId().equals(id)) {
                return loanList.get(i);
            }
        }
        return null;
    }

    public boolean delete (String id) {
        for (int i=0; i<loanList.size(); i++) {
            if (loanList.get(i).getId().equals(id)) {
                loanList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Loan getByMemberId(String memberId) {
        for (int i=0; i<loanList.size(); i++) {
            if (loanList.get(i).getMemberId().equals(memberId)) {
                return loanList.get(i);
            }
        }
        return null;
    }
}
