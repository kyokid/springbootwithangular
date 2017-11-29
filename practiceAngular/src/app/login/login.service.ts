import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import {Observable} from "rxjs/Observable";
import {of} from "rxjs/observable/of";
import {catchError} from "rxjs/operators";


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable()
export class LoginService {

  private apiUrl = 'api/login'

  constructor(private http: HttpClient) { }

  login(user: User): Observable<string> {
    return this.http.post<string>(this.apiUrl, user, httpOptions).pipe(
        catchError(this.handleError<string>('login'))
    )
  }

    private handleError<T> (operation = 'operation', result? :T) {
        return (error: any): Observable<T> => {
            console.error(error);

            return of(result as T)
        }
    }

}
