package com.goit.pshcherba.exception;


/**
 * Exception thrown when an error occurs while deleting a note.
 * Extends {@link NoteException} and provides a specific message
 * indicating that the note with the given ID was not found and could not be deleted.
 */
public class NoteDeleteException extends NoteException {

    /**
     * Constructs a new NoteDeleteException with a detailed message
     * specifying the ID of the note that could not be deleted.
     *
     * @param id the ID of the note that could not be deleted.
     */
    public NoteDeleteException(long id) {
        super("Delete note error. Note by id = " + id + " not found.");
    }
}
