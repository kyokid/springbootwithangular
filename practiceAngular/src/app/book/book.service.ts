import { Injectable } from '@angular/core';
import { Book } from "./book";
import { HttpClient } from "@angular/common/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable} from "rxjs/Observable";


@Injectable()
export class BookService {

  private readonly apiUrl = '/api/book';
  constructor(private http: HttpClient) { }

  findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiUrl}/getAll`);
  }

  getBook(id: number): Observable<Book> {
    const url = `${this.apiUrl}/findone?title=${id}`;
    return this.http.get<Book>(url);
  }

  saveBook(book: Book): Observable<Book> {
    return null;
  }

  deleteBookById(id: number): Observable<boolean> {
    return null
  }

  updateBook(book: Book): Observable<Book> {
    return null;
  }

}
