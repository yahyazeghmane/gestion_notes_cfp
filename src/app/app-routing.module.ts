import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListNotesComponent} from "./components/list-notes/list-notes.component";

const routes: Routes = [
  {path: "list-notes", component: ListNotesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
