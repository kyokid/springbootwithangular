package com.example.demo.book;

import com.example.demo.book.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long>{
    List<BookEntity> findByTitleLikeIgnoreCase(String title);
}
