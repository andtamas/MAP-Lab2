package com.example.Library.model;

public class ReadableItem {
    private String id;
    private String publicationId;
    private String barcode;
    private ReservationStatus status; // Available / Borrowed / Reserved

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
}
