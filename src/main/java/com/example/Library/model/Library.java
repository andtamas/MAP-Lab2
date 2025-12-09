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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adăugat: Generarea automată a ID-ului
    private Long id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 3, message = "Numele trebuie să aibă minim 3 caractere.")
    private String name;

    // Relatia One-to-Many cu Member
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members = new ArrayList<>();

    // Relatia One-to-Many cu ReadableItem
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadableItem> readableItems = new ArrayList<>();

    public Library() {}

    public Library(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<ReadableItem> getReadableItems() {
        return readableItems;
    }

    public void setReadableItems(List<ReadableItem> readableItems) {
        this.readableItems = readableItems;
    }

    public void addMember(Member member) {
        members.add(member);
        member.setLibrary(this);
    }

    public void removeMember(Member member) {
        members.remove(member);
        member.setLibrary(null);
    }

    public void addReadableItem(ReadableItem item) {
        readableItems.add(item);
        item.setLibrary(this);
    }

    public void removeReadableItem(ReadableItem item) {
        readableItems.remove(item);
        item.setLibrary(null);
    }

    @Override
    public String toString() {
        return "Library{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members.size() +
                ", readableItems=" + readableItems.size() +
                '}';
    }
}