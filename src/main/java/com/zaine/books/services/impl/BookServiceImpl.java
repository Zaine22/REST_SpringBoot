package com.zaine.books.services.impl;

import com.zaine.books.domain.Book;
import com.zaine.books.domain.BookEntity;
import com.zaine.books.repositories.BookRepository;
import com.zaine.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(final  BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(final Book book) {
        final BookEntity bookEntity =bookToBookEntity(book);
        final BookEntity saveBookEntity = bookRepository.save(bookEntity);
        return bookEntityToBook(saveBookEntity);
    }

    private BookEntity bookToBookEntity(Book book){
        return BookEntity.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private Book bookEntityToBook(BookEntity bookEntity){
        return Book.builder()
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .build();
    }
}
