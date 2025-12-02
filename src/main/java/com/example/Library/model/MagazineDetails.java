package com.example.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "magazine_details")
public class MagazineDetails extends Publication {

    // Câmpul este acum 'editor' și are nevoie de validare
    @NotBlank(message = "Editorul revistei este obligatoriu.")
    private String editor;

    public MagazineDetails() {}

    public MagazineDetails(String id, String title, List<ReadableItem> copies, String editor) {
        super(id, title, copies);
        this.editor = editor;
    }

    // Noul Getter/Setter pentru 'editor'
    public String getEditor() { return editor; }
    public void setEditor(String editor) { this.editor = editor; }

    // Notă: getPublisher/setPublisher nu mai există
}