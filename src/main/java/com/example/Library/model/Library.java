package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraries")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 3, message = "Numele trebuie să aibă minim 3 caractere.")
    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadableItem> readableItems = new ArrayList<>();

    // Constructor JPA
    protected Library() {
    }

    // Constructor business (fără ID)
    public Library(String name) {
        this.name = name;
    }

    // --- Getters ---

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<ReadableItem> getReadableItems() {
        return readableItems;
    }

    // --- Setters business (fără setId!) ---

    public void setName(String name) {
        this.name = name;
    }

    // --- Metode corecte pentru relația bidirecțională ---

    public void addMember(Member member) {
        if (!members.contains(member)) {
            members.add(member);
            member.setLibrary(this);
        }
    }

    public void removeMember(Member member) {
        if (members.remove(member)) {
            member.setLibrary(null);
        }
    }

    public void addReadableItem(ReadableItem item) {
        if (!readableItems.contains(item)) {
            readableItems.add(item);
            item.setLibrary(this);
        }
    }
}