import {Component, OnInit} from '@angular/core';
import {NotesService} from "../../services/notes.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NoteModel} from "../../models/note";
import {PageResponse} from "../../models/pageResponse";

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.css']
})
export class ListNotesComponent implements OnInit {
  notes!: PageResponse<NoteModel>;
  constructor(private noteService: NotesService) {
  }

  ngOnInit(): void {
    this.getNotes();
  }

  getNotes() {
    this.noteService.listNotes().subscribe({
      next: (data) => {
        console.log("data", data.content);
        this.notes = data;
      },
      error: (err: HttpErrorResponse) => {
        console.log("error", err);
      }
    });
  }

}
