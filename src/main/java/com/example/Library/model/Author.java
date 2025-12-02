package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @NotBlank(message = "ID-ul autorului este obligatoriu.")
    private String id;

    @NotBlank(message = "Numele este obligatoriu.")
    private String name;

    private String nationality;

    // Relația One-to-Many (pentru a putea fi mapată corespunzător în baza de date)
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookAuthor> books;

    // ... Constructor, Getters, Setters
    // (Actualizați constructorul pentru a folosi campuri simple și JPA)
}