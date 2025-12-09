package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull; // Adăugat
import java.util.List;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adăugat: Generarea automată a ID-ului
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @NotNull(message = "Membrul este obligatoriu.") // Adăugat
    private Member member;

    @Transient // Marcat ca non-persistent
    @NotNull(message = "ID-ul membrului este obligatoriu.") // Corectat din @NotBlank
    private Long memberId;

    @NotBlank(message = "Data este obligatorie.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Format data invalid (YYYY-MM-DD).")
    private String date;

    @Transient // Adăugat: Câmp nepersistent
    private List<Reservation> reservations;

    @Transient // Adăugat: Câmp nepersistent
    private List<ReadableItem> items;

    public Loan() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getMemberId() {
        if (member != null) {
            return member.getId();
        }
        return memberId;
    }

    public void setMemberId(Long memberId) {
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