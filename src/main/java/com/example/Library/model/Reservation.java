package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull; // Adăugat

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adăugat: Generarea automată a ID-ului
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @NotNull(message = "Membrul este obligatoriu.") // Adăugat
    private Member member;

    @Transient
    @NotNull(message = "ID-ul membrului este obligatoriu.") // Corectat din @NotBlank
    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readable_item_id", nullable = false)
    @NotNull(message = "Exemplarul este obligatoriu.") // Adăugat
    private ReadableItem readableItem;

    @Transient
    @NotNull(message = "ID-ul exemplarului este obligatoriu.") // Corectat din @NotBlank
    private Long readableItemId;

    @NotBlank(message = "Data este obligatorie.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Format data invalid (YYYY-MM-DD).")
    private String date;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Statusul este obligatoriu.") // Adăugat
    private ReservationStatus status; // Active / Cancelled / Completed

    public Reservation() {}

    public Long getId() {
        return id;
    }

    // Curățat de adnotarea incorectă (@NotBlank) de pe parametru
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

    // Curățat de adnotările incorecte (@NotBlank) de pe metoda getter
    public Long getMemberId() {
        if (member != null) {
            return member.getId();
        }
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public ReadableItem getReadableItem() {
        return readableItem;
    }

    public void setReadableItem(ReadableItem readableItem) {
        this.readableItem = readableItem;
        if (readableItem != null) {
            this.readableItemId = readableItem.getId();
        }
    }

    public Long getReadableItemId() {
        if (readableItem != null) {
            return readableItem.getId();
        }
        return readableItemId;
    }

    public void setReadableItemId(Long readableItemId) {
        this.readableItemId = readableItemId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}