package com.example.Library.model;

import com.example.Library.model.Publication;
import com.example.Library.model.ReadableItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "magazine_details")
public class MagazineDetails extends Publication {

    private String editor;

    public MagazineDetails() {}

    public MagazineDetails(String id, String title, List<ReadableItem> copies, String editor) {
        super(id, title, copies);
        this.editor = editor;
    }

    public String getEditor() { return editor; }
    public void setEditor(String editor) { this.editor = editor; }
}
