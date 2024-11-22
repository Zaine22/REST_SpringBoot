package com.zaine.books.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaine.books.TestData;
import com.zaine.books.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class BookControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBookIsCreated()throws Exception{
        final Book book = TestData.testBook();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String bookJson  =    objectMapper.writeValueAsString(book);
    mockMvc.perform(MockMvcRequestBuilders.put("/books"+ book.getIsbn()).content("application/json")).andExpect(MockMvcResultMatchers.content().json(bookJson));
    }
}
