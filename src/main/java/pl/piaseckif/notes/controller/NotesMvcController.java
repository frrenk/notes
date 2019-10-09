package pl.piaseckif.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piaseckif.notes.repository.NoteRepository;

@Controller
public class NotesMvcController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(value = "/hello")
    public String Hello() {
        return "hello";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String showNotes(Model model) {
        model.addAttribute("notes", noteRepository.findAll());
        return "notes";
    }
}
