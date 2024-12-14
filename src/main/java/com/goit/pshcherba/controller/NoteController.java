package com.goit.pshcherba.controller;

import com.goit.pshcherba.entity.Note;
import com.goit.pshcherba.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Controller class for managing notes.
 * Handles HTTP requests for creating, updating, deleting, and retrieving notes.
 */
@Controller
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;


    /**
     * Redirects the root URL ("/") to the list of notes.
     *
     * @return a {@link ModelAndView} object redirecting to the "/note/list" endpoint.
     */
    @GetMapping("/")
    public ModelAndView redirectToNotes() {
        return new ModelAndView("redirect:/note/list");
    }


    /**
     * Adds a new note with the specified title and content.
     *
     * @param title   the title of the note to be added.
     * @param content the content of the note to be added.
     * @return a {@link ModelAndView} object redirecting to the "/note/list" endpoint.
     */
    @PostMapping("/note/add")
    public ModelAndView addNote(@RequestParam String title, @RequestParam String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new ModelAndView("redirect:/note/list");
    }


    /**
     * Updates an existing note based on the provided note object.
     *
     * @param note the {@link Note} object containing updated information.
     * @return a {@link ModelAndView} object redirecting to the "/note/list" endpoint.
     */
    @PostMapping("/note/edit")
    public ModelAndView editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }


    /**
     * Deletes an existing note by its ID.
     *
     * @param id the ID of the note to be deleted.
     * @return a {@link ModelAndView} object redirecting to the "/note/list" endpoint.
     */
    @PostMapping("/note/delete")
    public ModelAndView deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }


    /**
     * Retrieves all notes and displays them in the "note" view.
     *
     * @return a {@link ModelAndView} object containing the list of notes.
     */
    @GetMapping("/note/list")
    public ModelAndView getAllNotes() {
        ModelAndView model = new ModelAndView("note");
        List<Note> notes = noteService.listAll();
        model.addObject("notes", notes);
        return model;
    }
}
