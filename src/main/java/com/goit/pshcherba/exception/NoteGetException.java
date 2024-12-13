package com.goit.pshcherba.exception;

/**
 * Exception thrown when an error occurs while retrieving a note.
 * Extends {@link NoteException} and provides a specific message
 * indicating that the note with the given ID was not found.
 */
public class NoteGetException extends NoteException {

    /**
     * Constructs a new NoteGetException with a detailed message
     * specifying the ID of the note that could not be found.
     *
     * @param id the ID of the note that could not be retrieved.
     */
    public NoteGetException(long id) {
        super("Get note error. Note by id = " + id + " not found.");
    }
}
