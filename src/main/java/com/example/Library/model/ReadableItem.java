package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "readable_items")
public class ReadableItem {

    @Id
    @NotBlank(message = "ID-ul exemplarului este obligatoriu.")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @NotBlank(message = "Codul de bare este obligatoriu.")
    private String barcode;

    @Enumerated(EnumType.STRING)
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
