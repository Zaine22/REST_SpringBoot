package com.zaine.books.controllers;

import com.zaine.books.domain.Book;
import com.zaine.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController (final BookService bookService){
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> createBook(@PathVariable final String isbn, @RequestBody final Book book){
        book.setIsbn(isbn);
        final Book saveBook = bookService.create(book);

        return new ResponseEntity<Book>(saveBook, HttpStatus.CREATED);
    }
}
