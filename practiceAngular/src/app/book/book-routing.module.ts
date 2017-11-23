import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent} from "./book-list/book-list.component";
import { BookCreateComponent} from "./book-create/book-create.component";

const routes: Routes = [
  {path: 'book', component: BookListComponent},
  {path: 'book/create', component: BookCreateComponent},
  {path: 'book/edit/:id', component: BookCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
