package com.snim.notes.controller;

import com.snim.notes.model.Note;
import com.snim.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public ResponseEntity<Page<Note>> list(
            @RequestParam(name = "page", required = false) Optional<Integer> page,
            @RequestParam(name = "size", required = false) Optional<Integer> size
    ){
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), Sort.by("createdAt").descending());
         Page<Note> notes = noteService.list(pageable);
        return ResponseEntity.ok(notes);
    }
}
