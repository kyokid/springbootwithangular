import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import {AppRoutingModule} from "./app-routing.module";
import {BookModule} from "./book/book.module";
import {AppComponent} from './app.component';
import {BookService} from './book/book.service'
import {FormsModule} from "@angular/forms";
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BookModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [BookService, LoginService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
