import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PageResponse} from "../models/pageResponse";
import {NoteModel} from "../models/note";

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private _http: HttpClient) { }

  public listNotes(page: number = 0, size: number = 10): Observable<PageResponse<NoteModel>>{
    return this._http.get<PageResponse<NoteModel>>(`${this.apiServerUrl}/notes/list?page=${page}&size=${size}`);
  }
}
