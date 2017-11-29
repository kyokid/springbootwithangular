import {Component, OnInit} from '@angular/core';
import {Book} from "../book";
import {BookService} from "../book.service";

@Component({
    selector: 'app-book-list',
    templateUrl: './book-list.component.html',
    styleUrls: ['./book-list.component.css'],
    providers: [BookService]
})
export class BookListComponent implements OnInit {

    private books: Book[];

    constructor(private bookService: BookService) {
    }

    ngOnInit() {
        this.getAllBooks();
    }


    getAllBooks() {
        this.bookService.findAll().subscribe(
            books => {
                this.books = books.sort(function (a, b) {
                    return a.id - b.id
                });
            },
            err => {
                console.log(err);
            }
        );
    }

    addBook(id: number, title: string, overview: string, price: number): void {
        title = title.trim()
        overview = overview.trim()
        if (!id || !title || !overview || !price) {
            return
        }
        var book: Book = new Book(id, title, overview, price)
        this.bookService.addBook(book)
            .subscribe(book => {
                this.books.push(book)
            })

    }

    delete(book: Book): void {
        this.books = this.books.filter(b => b !== book);
        this.bookService.deleteBookById(book.id).subscribe()
    }

}
