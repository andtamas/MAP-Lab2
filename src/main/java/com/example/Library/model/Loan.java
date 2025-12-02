package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @NotBlank(message = "ID-ul împrumutului este obligatoriu.")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Transient
    @NotBlank(message = "ID-ul membrului este obligatoriu.")
    private String memberId;

    @NotBlank(message = "Data este obligatorie.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Format data invalid (YYYY-MM-DD).")
    private String date;

    @Transient
    private List<Reservation> reservations;

    @Transient
    private List<ReadableItem> items;

    public Loan() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            this.memberId = member.getId();
        }
    }

    public String getMemberId() {
        if (member != null) {
            return member.getId();
        }
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
