package com.goit.pshcherba.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class representing a note.
 * Contains fields for ID, title, and content, along with
 * relevant constructors, getters, and setters.
 */
@Data
@NoArgsConstructor
public class Note {
    private long id;
    private String title;
    private String content;


    /**
     * Constructor for creating a note with a title and content.
     * The ID is not set and should be assigned later by the service.
     *
     * @param title   the title of the note.
     * @param content the content of the note.
     */
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}