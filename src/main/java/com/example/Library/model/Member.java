package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @NotBlank(message = "ID-ul este obligatoriu.")
    private String id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 2, max = 100, message = "Numele trebuie sa aiba intre 2 si 100 de caractere.")
    private String name;

    @Email(message = "Format email invalid.")
    @NotBlank(message = "Email-ul este obligatoriu.")
    private String email;

    // Relatia Many-to-One cu Library (coloana FK va fi 'library_id')
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @Transient // Marcam campul vechi pentru a-l folosi in formularul Thymeleaf
    @NotBlank(message = "ID-ul bibliotecii este obligatoriu pentru validarea business.")
    private String libraryId;

    // Relatia One-to-Many cu Reservation
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    // Relatia One-to-Many cu Loan
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    public Member() {}

    // Constructorul este simplificat pentru a folosi JPA

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
        this.library = library;
    }

    // Metoda ajutătoare pentru Thymeleaf/Form
    public String getLibraryId() {
        return library != null ? library.getId() : libraryId;
    }

    // Metoda ajutătoare pentru Thymeleaf/Form
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