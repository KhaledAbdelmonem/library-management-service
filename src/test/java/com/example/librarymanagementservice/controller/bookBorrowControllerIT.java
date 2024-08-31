package com.example.librarymanagementservice.controller;

import com.example.librarymanagementservice.dto.BookDTO;
import com.example.librarymanagementservice.dto.BorrowingRecordDTO;
import com.example.librarymanagementservice.dto.PatronDTO;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class bookBorrowControllerIT extends LibraryBaseTestIT {
    @Test
    public void canBorrowBook() throws Exception {

        BookDTO bookDTO = registerBook("Marijn Haverbeke", "Eloquent JavaScript, Third Edition", "9781593279509", LocalDate.now());
        PatronDTO patronDTO = registerPatron("John Smith", "example@test.com", "NewYork", "212 555-1234", "21 2nd Street", 25);

        final Long bookId = bookDTO.getId();
        final Long patronId = patronDTO.getId();


        BorrowingRecordDTO borrowingRecordDTO = bookBorrow(bookId, patronId);

        assertEquals(bookDTO.getId(), borrowingRecordDTO.getBookDto().getId());
        assertEquals(patronDTO.getId(), borrowingRecordDTO.getPatronDto().getId());

    }

    @Test
    public void canReturnBook() throws Exception {

        BookDTO bookDTO = registerBook("Marijn Haverbeke", "Eloquent JavaScript, Third Edition", "9781593279509", LocalDate.now());
        PatronDTO patronDTO = registerPatron("John Smith", "example@test.com", "NewYork", "212 555-1234", "21 2nd Street", 25);

        final Long bookId = bookDTO.getId();
        final Long patronId = patronDTO.getId();

        bookBorrow(bookId, patronId);

        final LocalDate returnDate = LocalDate.of(2020, 1, 1);

        BorrowingRecordDTO borrowingRecordDTO = returnBook(bookId, patronId, returnDate);

        assertEquals(bookDTO.getId(), borrowingRecordDTO.getBookDto().getId());
        assertEquals(patronDTO.getId(), borrowingRecordDTO.getPatronDto().getId());
        assertEquals(returnDate, borrowingRecordDTO.getReturnDate());

    }
}
