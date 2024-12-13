package com.goit.pshcherba.service;

import com.goit.pshcherba.entity.Note;
import com.goit.pshcherba.exception.NoteDeleteException;
import com.goit.pshcherba.exception.NoteGetException;
import com.goit.pshcherba.exception.NoteUpdateException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class for managing notes.
 * Provides basic CRUD operations for working with notes.
 */
@Service
public class NoteServiceImpl implements NoteService {
    private final Map<Long, Note> noteMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);


    /**
     * Retrieves a list of all notes.
     *
     * @return a list containing all notes in the service.
     */
    @Override
    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }


    /**
     * Adds a new note to the service.
     * Generates a unique ID for the note and stores it in the map.
     *
     * @param note the note to add.
     * @return the added note with its generated ID.
     */
    @Override
    public Note add(Note note) {
        long id = idGenerator.getAndIncrement();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    /**
     * Deletes a note by its ID.
     * If no note with the given ID exists, a {@link NoSuchElementException} is thrown.
     *
     * @param id the ID of the note to delete.
     * @throws NoSuchElementException if no note with the given ID is found.
     */
    @Override
    public void deleteById(long id) {
        if (noteMap.remove(id) == null) {
            throw new NoteDeleteException(id);
        }
    }


    /**
     * Updates an existing note.
     * If the note with the given ID does not exist, a {@link NoSuchElementException} is thrown.
     *
     * @param note the note containing updated data.
     * @throws NoSuchElementException if no note with the given ID is found.
     */
    @Override
    public void update(Note note) throws NoteUpdateException {
        long id = note.getId();
        if (!noteMap.containsKey(id)) {
            throw new NoteUpdateException(id);
        }
        Note existingNote = noteMap.get(id);
        if (note.getTitle() != null) {
            existingNote.setTitle(note.getTitle());
        }
        if (note.getContent() != null) {
            existingNote.setContent(note.getContent());
        }
    }
}
