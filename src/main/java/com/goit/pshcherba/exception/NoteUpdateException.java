package com.goit.pshcherba.exception;


/**
 * Exception thrown when an error occurs while updating a note.
 * Extends {@link NoteException} and provides a specific message
 * indicating that the note with the given ID was not found and could not be updated.
 */
public class NoteUpdateException extends NoteException {

    /**
     * Constructs a new NoteUpdateException with a detailed message
     * specifying the ID of the note that could not be updated.
     *
     * @param id the ID of the note that could not be updated.
     */
    public NoteUpdateException(long id) {
        super("Update note error. Note by id = " + id + " not found.");
    }
}
