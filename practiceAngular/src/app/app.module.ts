import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from "./app-routing.module";
import {BookModule} from "./book/book.module";
import {AppComponent} from './app.component';
import {BookService} from './book/book.service'
import {FormsModule} from "@angular/forms";

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BookModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [BookService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
