package com.example.Library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "magazine_details")
public class MagazineDetails extends Publication {

    @NotBlank(message = "Editorul revistei este obligatoriu.")
    private String editor;

    @NotNull(message = "Anul este obligatoriu.")
    private Integer year;

    public MagazineDetails() {}

    public MagazineDetails(String id, String title, List<ReadableItem> copies, String editor, Integer year) {
        super(id, title, copies);
        this.editor = editor;
        this.year = year;
    }

    // Getter/Setter pentru 'editor'
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    // Alias pentru compatibilitate getPublisher/setPublisher
    public String getPublisher() {
        return editor;
    }

    public void setPublisher(String publisher) {
        this.editor = publisher;
    }

    // Getter/Setter pentru 'year'
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
