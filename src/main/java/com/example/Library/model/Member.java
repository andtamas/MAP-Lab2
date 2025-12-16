package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @NotBlank(message = "Numele este obligatoriu.")
    private String name;

    @NotBlank(message = "Emailul este obligatoriu.")
    @Email(message = "Format email invalid.")
    private String email;

    // Câmp utilitar pentru a prelua ID-ul din formular
    @Transient
    // MODIFICAT: S-a eliminat @NotNull. Validarea este acum gestionată de Controller/Service.
    private Long libraryId;

    // Relația ManyToOne cu Library (cheia străină)
    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    // Relația OneToMany cu Loan
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Loan> loans = new HashSet<>();

    // Relația OneToMany cu Reservation
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();


    // --- Constructors ---

    public Member() {
    }

    public Member(String name, String email, Library library) {
        this.name = name;
        this.email = email;
        this.setLibrary(library);
    }

    // --- Loans Management (Utilities) ---

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setMember(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setMember(null);
    }

    // --- Reservations Management (Utilities) ---

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setMember(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setMember(null);
    }


    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        if (this.library != null) {
            this.library.getMembers().remove(this);
        }
        this.library = library;
        if (library != null) {
            library.getMembers().add(this);
        }
    }

    // Corecție pentru afișarea ID-ului în UI (când este încărcat din baza de date)
    public Long getLibraryId() {
        if (this.library != null) {
            return this.library.getId();
        }
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}