package com.example.Library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "magazine_details")
public class MagazineDetails extends Publication {

    private String editor;
    private int year;

    public MagazineDetails() {}

    public MagazineDetails(Long id, String title, List<ReadableItem> copies, String editor, int year) {
        super(id, title, copies);
        this.editor = editor;
        this.year = year;
    }

    public String getEditor() { return editor; }
    public void setEditor(String editor) { this.editor = editor; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    private String publisher;

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

}
