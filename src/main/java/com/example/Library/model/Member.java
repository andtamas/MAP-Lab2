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
    @Size(min = 2, message = "Numele trebuie sa aiba minim 2 caractere.")
    private String name;

    @Email(message = "Format email invalid.")
    @NotBlank(message = "Email-ul este obligatoriu.")
    private String email;

    // Relația Many-to-One cu Library (Cheia străină: library_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    @Transient // Câmpul vechi libraryId devine tranzitoriu
    @NotBlank(message = "ID-ul bibliotecii este obligatoriu.")
    private String libraryId;

    // Relații One-to-Many cu Reservation și Loan
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

    public Member() {}

    // ... Constructorul trebuie ajustat pentru a primi Library sau a folosi setLibraryId

    public String getLibraryId() {
        return library != null ? library.getId() : libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        // Logică necesară în Service/Controller pentru a converti ID-ul în obiectul Library
    }

    // ... Getters and Setters pentru ID, Name, Email (restul sunt similare)

    public String getId() {
        return id;
    }
    // ... restul getters/setters

    public void setLibrary(Library library) {
        this.library = library;
    }
}