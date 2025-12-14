package com.example.Library.model;

import com.example.Library.model.Library;
import com.example.Library.model.Loan;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // nu mai avem setId

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name = "library_fk", nullable = false)
    private Library library;

    @Transient
    private Long libraryId; // pentru Thymeleaf

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @OneToMany(mappedBy = "member")
    private Set<Loan> loans = new HashSet<>();

    // --- Constructori ---
    public Member() {
    }

    public Member(String name, String email, Library library) {
        this.name = name;
        this.email = email;
        this.library = library;
        if (library != null) {
            this.libraryId = library.getId();
        }
    }

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public Library getLibrary() {
        return library;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    // --- Setters ---
    public void setLibrary(Library library) {
        this.library = library;
        if (library != null) {
            this.libraryId = library.getId();
        } else {
            this.libraryId = null;
        }
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
        if (libraryId != null) {
            Library lib = new Library();
            lib.setId(libraryId);
            this.library = lib;
        } else {
            this.library = null;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
