package com.zaine.books.services.impl;

import com.zaine.books.domain.Book;
import com.zaine.books.domain.BookEntity;
import com.zaine.books.repositories.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;


@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved(){
        final Book book = Book.builder()
                .isbn("123456")
                .author("zaine")
                .title("kyawkokozin")
                .build();

        final BookEntity bookEntity = BookEntity.builder()
                .isbn("123456")
                .author("zaine")
                .title("kyawkokozin")
                .build();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);


        final Book result = underTest.create(book);

        assertEquals(book, result);

    }

}
