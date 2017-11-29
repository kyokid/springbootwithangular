import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from "./book/book-list/book-list.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
    { path: '', redirectTo: '/', pathMatch: 'full'},
    { path: 'books', component: BookListComponent },
    { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
