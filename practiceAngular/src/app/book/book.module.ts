import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BookRoutingModule} from './book-routing.module';
import {BookListComponent} from './book-list/book-list.component';
import {BookCreateComponent} from './book-create/book-create.component';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
    imports: [
        CommonModule,
        BookRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    declarations: [BookListComponent, BookCreateComponent, BookDetailComponent]
})
export class BookModule {
}
