package com.example.Library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Poți folosi SINGLE_TABLE dacă vrei o singură tabelă
public abstract class Publication {

    @Id
    private String id;

    private String title;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReadableItem> copies;

    public Publication() {}

    public Publication(String id, String title, List<ReadableItem> copies) {
        this.id = id;
        this.title = title;
        this.copies = copies;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<ReadableItem> getCopies() { return copies; }
    public void setCopies(List<ReadableItem> copies) { this.copies = copies; }
}
