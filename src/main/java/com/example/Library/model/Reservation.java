package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @NotBlank(message = "ID-ul rezervării este obligatoriu.")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Transient
    @NotBlank(message = "ID-ul membrului este obligatoriu.")
    private String memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "readable_item_id", nullable = false)
    private ReadableItem readableItem;

    @Transient
    @NotBlank(message = "ID-ul exemplarului este obligatoriu.")
    private String readableItemId;

    @NotBlank(message = "Data este obligatorie.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Format data invalid (YYYY-MM-DD).")
    private String date;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // Active / Cancelled / Completed

    public Reservation() {}

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

    public ReadableItem getReadableItem() {
        return readableItem;
    }

    public void setReadableItem(ReadableItem readableItem) {
        this.readableItem = readableItem;
        if (readableItem != null) {
            this.readableItemId = readableItem.getId();
        }
    }

    public String getReadableItemId() {
        if (readableItem != null) {
            return readableItem.getId();
        }
        return readableItemId;
    }

    public void setReadableItemId(String readableItemId) {
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
