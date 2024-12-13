package com.goit.pshcherba.exception;


/**
 * Abstract class representing a custom exception for note-related errors.
 * This class extends {@link RuntimeException} and serves as a base class for other
 * specific exceptions related to notes.
 */
public abstract class NoteException extends RuntimeException {

    /**
     * Constructs a new NoteException with the specified detail message.
     *
     * @param message the detail message to be associated with the exception.
     */
    NoteException(String message) {
        super(message);
    }
}
