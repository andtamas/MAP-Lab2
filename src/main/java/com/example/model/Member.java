package com.example.model;

import java.util.List;

public class Member {
    private String id;
    private String name;
    private String libraryId;
    private List<Reservation> reservations;
    private List<Loan> loans;

    public Member() {}

    public Member(String id, String name, String libraryId, List<Reservation> reservations, List<Loan> loans) {
        this.id = id;
        this.name = name;
        this.libraryId = libraryId;
        this.reservations = reservations;
        this.loans = loans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
