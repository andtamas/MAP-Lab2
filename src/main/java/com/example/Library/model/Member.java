package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull; // Adăugat
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adăugat: Generarea automată a ID-ului
    private Long id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 2, max = 100, message = "Numele trebuie sa aiba intre 2 si 100 de caractere.")
    private String name;

    @Email(message = "Format email invalid.")
    @NotBlank(message = "Email-ul este obligatoriu.")
    private String email;

    // Relatia Many-to-One cu Library (coloana FK va fi 'library_id')
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    @NotNull(message = "Biblioteca este obligatorie.") // Adăugat: Validare pe entitate
    private Library library;

    @Transient // Marcam campul auxiliar
    @NotNull(message = "ID-ul bibliotecii este obligatoriu pentru validarea business.") // Corectat din @NotBlank
    private Long libraryId;

    // Relatia One-to-Many cu Reservation
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    // Relatia One-to-Many cu Loan
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    public Member() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Long getLibraryId() {
        return library != null ? library.getId() : libraryId;
    }

    // Metoda ajutătoare pentru Thymeleaf/Form
    public void setLibraryId(Long libraryId) {
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