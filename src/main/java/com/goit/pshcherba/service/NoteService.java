package com.goit.pshcherba.service;

import com.goit.pshcherba.entity.Note;

import java.util.List;

/**
 * Service interface for managing notes.
 * Provides methods to perform CRUD (Create, Read, Update, Delete) operations
 * on notes in the application.
 */
public interface NoteService {


    /**
     * Retrieves a list of all notes.
     *
     * @return a list of all {@link Note} objects.
     */
    List<Note> listAll();


    /**
     * Adds a new note to the system.
     *
     * @param note the {@link Note} object to be added.
     * @return the added {@link Note} object.
     */
    Note add(Note note);

    /**
     * Deletes a note by its ID.
     *
     * @param id the ID of the note to be deleted.
     */
    void deleteById(long id);


    /**
     * Updates an existing note.
     *
     * @param note the {@link Note} object containing updated information.
     */
    void update(Note note);
}
