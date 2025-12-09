package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull; // Adăugat

@Entity
@Table(name = "readable_items")
public class ReadableItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adăugat: Generarea automată a ID-ului
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id", nullable = false)
    @NotNull(message = "Publicația este obligatorie.")
    private Publication publication;

    @NotBlank(message = "Codul de bare este obligatoriu.")
    private String barcode;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Statusul este obligatoriu.") // Adăugat
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    public ReadableItem() {}

    public ReadableItem(Long id, Publication publication, String barcode, ReservationStatus status) {
        this.id = id;
        this.publication = publication;
        this.barcode = barcode;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Publication getPublication() { return publication; }
    public void setPublication(Publication publication) { this.publication = publication; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }

    public Library getLibrary() { return library; }
    public void setLibrary(Library library) { this.library = library; }
}