package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = "/getAll")
    public List<BookEntity> getAll() {
        List<BookEntity> listBooks = new ArrayList<>();
        Iterable<BookEntity> books = bookRepository.findAll();
        books.forEach(listBooks::add);
        return listBooks;
    }

    @GetMapping(value = "/find")
    public List<BookEntity> findBookByTitle(@RequestParam("title") String title) {
        List<BookEntity> booksFound = new ArrayList<>();
        Iterable<BookEntity> books = bookRepository.findByTitleLikeIgnoreCase("%" + title + "%");
        books.forEach(booksFound::add);
        return booksFound;
    }

    @GetMapping("findone")
    public BookEntity findOneBookByTitle(@RequestParam("id") Long id) {
        BookEntity bookFound = bookRepository.findOne(id);
        return bookFound;
    }

    @PostMapping("/add")
    public BookEntity addBook(@RequestBody BookEntity bookEntity) {

        bookEntity = bookRepository.save(new BookEntity(bookEntity.getTitle(), bookEntity.getOverview(), bookEntity.getPrice()));
        return bookEntity;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Long id) {
       bookRepository.delete(id);
       return "Delete successful";
    }

    @PutMapping("update/{id}")
    public String updateBookById(@PathVariable Long id, @RequestBody BookEntity bookEntity) {
        BookEntity bookFound = bookRepository.findOne(id);

        if (null == bookFound) {
            return "Not found book";
        }
        bookRepository.save(bookEntity);
        return "Update successful";
    }


}
