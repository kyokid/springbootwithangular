import {Injectable} from '@angular/core';
import {Book} from "./book";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import {Observable} from "rxjs/Observable";
import {of} from "rxjs/observable/of";
import {catchError} from "rxjs/operators";

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable()
export class BookService {

    private readonly apiUrl = '/api/book';

    constructor(private http: HttpClient) {
    }

    findAll(): Observable<Book[]> {
        return this.http.get<Book[]>(`${this.apiUrl}/getAll`);
    }

    getBook(id: number): Observable<Book> {
        const url = `${this.apiUrl}/findone?id=${id}`;
        return this.http.get<Book>(url);
    }

    addBook(book: Book): Observable<Book> {
        const url = `${this.apiUrl}/add`
        return this.http.post<Book>(url, book, httpOptions).pipe(
            catchError(this.handleError<Book>('addBook'))
        )
    }

    deleteBookById(id: number): Observable<Book> {
        const url = `${this.apiUrl}/delete/${id}`

        return this.http.delete<Book>(url, httpOptions).pipe(
            catchError(this.handleError<Book>('deleteBook'))
        )
    }

    updateBook(book: Book): Observable<any> {
        const url = `${this.apiUrl}/update/${book.id}`
        console.warn(book)
        return this.http.put(url, book, httpOptions).pipe(
            catchError(this.handleError<any>('updateBook'))
        );
    }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            return of(result as T);
        }
    }
}
