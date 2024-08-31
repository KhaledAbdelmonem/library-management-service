package com.example.librarymanagementservice.controller;

import com.example.librarymanagementservice.dto.BookDTO;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BookControllerIT extends LibraryBaseTestIT {
    @Test
    public void canRegisterBook() throws Exception {

        final String AUTHOR = "Marijn Haverbeke";
        final String TITLE = "Eloquent JavaScript, Third Edition";
        final String ISBN = "9781593279509";
        final LocalDate PUBLISHER_DATE = LocalDate.of(2018, 4, 12);

        BookDTO bookDTO = registerBook(AUTHOR, TITLE, ISBN, PUBLISHER_DATE);

        assertEquals(TITLE, bookDTO.getTitle());
        assertEquals(AUTHOR, bookDTO.getAuthor());
        assertEquals(ISBN, bookDTO.getIsbn());
    }

}
