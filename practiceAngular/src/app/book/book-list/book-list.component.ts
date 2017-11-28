import { Component, OnInit } from '@angular/core';
import { Book } from "../book";
import { BookService } from "../book.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  private books: Book[];

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.getAllBooks();
  }


  getAllBooks() {
    this.bookService.findAll().subscribe(
      books => {
        this.books = books.sort(function(a, b) {return a.id-b.id});
      },
      err => {
        console.log(err);
      }
    );
  }

}
