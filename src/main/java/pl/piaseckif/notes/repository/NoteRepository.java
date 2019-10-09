package pl.piaseckif.notes.repository;

import org.springframework.data.repository.CrudRepository;
import pl.piaseckif.notes.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
