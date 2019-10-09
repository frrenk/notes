package pl.piaseckif.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.piaseckif.notes.entity.Note;
import pl.piaseckif.notes.repository.NoteRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping(path="/api")
public class NoteRestController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping(path = "/notes")
    public @ResponseBody Iterable<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewNote (@RequestBody String content) {
        Note note = new Note(content, Timestamp.valueOf(LocalDateTime.now()));
        noteRepository.save(note);
        return "Saved";
    }
}
