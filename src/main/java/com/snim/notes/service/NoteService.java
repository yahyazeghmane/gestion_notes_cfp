package com.snim.notes.service;

import com.snim.notes.model.Note;
import com.snim.notes.repository.NoteRepo;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public Page<Note> list(Pageable pageable){
        Page<Note> notes = noteRepo.findAll(pageable);
        return  notes;
    }
}
