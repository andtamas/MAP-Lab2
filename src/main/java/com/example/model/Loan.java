package com.example.model;

import java.util.List;

public class Loan {
    private String id;
    private String memberId;
    private String date;
    private List<Reservation> reservations;
    private List<ReadableItem> items;

    public Loan() {}

    public Loan(String id, String memberId, String date, List<Reservation> reservations, List<ReadableItem> items) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.reservations = reservations;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<ReadableItem> getItems() {
        return items;
    }

    public void setItems(List<ReadableItem> items) {
        this.items = items;
    }
}
