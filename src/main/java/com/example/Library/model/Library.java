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
    @NotBlank(message = "ID-ul bibliotecii este obligatoriu.")
    private String id;

    @NotBlank(message = "Numele este obligatoriu.")
    @Size(min = 3, message = "Numele trebuie să aibă minim 3 caractere.")
    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadableItem> readableItems = new ArrayList<>();

    public Library() {}

    public Library(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}