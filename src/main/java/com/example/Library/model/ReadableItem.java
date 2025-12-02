package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "readable_items")
public class ReadableItem {

    @Id
    @NotBlank(message = "ID-ul exemplarului este obligatoriu.")
    private String id;

    @Transient
    @NotBlank(message = "ID-ul publicației este obligatoriu.")
    private String publicationId;

    @NotBlank(message = "Codul de bare este obligatoriu.")
    private String barcode;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // Available / Borrowed / Reserved

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    public ReadableItem() {}

    public ReadableItem(String id, String publicationId, String barcode, ReservationStatus status) {
        this.id = id;
        this.publicationId = publicationId;
        this.barcode = barcode;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "ReadableItem{" +
                "id='" + id + '\'' +
                ", publicationId='" + publicationId + '\'' +
                ", barcode='" + barcode + '\'' +
                ", status=" + status +
                '}';
    }
}
