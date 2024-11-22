package com.zaine.books;

import com.zaine.books.domain.Book;
import com.zaine.books.domain.BookEntity;

public class TestData {

    private TestData(){

    }

    public static Book testBook(){
        return Book.builder()
                .isbn("123456")
                .author("zaine")
                .title("kyawkokozin")
                .build();
    }public static BookEntity testBookEntity(){
        return BookEntity.builder()
                .isbn("123456")
                .author("zaine")
                .title("kyawkokozin")
                .build();
    }
}
