import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BookListComponent} from "./book-list/book-list.component";
import {BookCreateComponent} from "./book-create/book-create.component";
import {BookDetailComponent} from "./book-detail/book-detail.component";

const routes: Routes = [
    {path: 'book', component: BookListComponent},
    {path: 'book/create', component: BookCreateComponent},
    {path: 'book/edit/:id', component: BookCreateComponent},
    {path: 'book/detail/:id', component: BookDetailComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class BookRoutingModule {
}
