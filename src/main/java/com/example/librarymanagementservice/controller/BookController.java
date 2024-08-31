package com.example.librarymanagementservice.controller;

import com.example.librarymanagementservice.dto.BookDTO;
import com.example.librarymanagementservice.service.impl.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("/")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) throws Exception {
        return bookService.getBook(id);
    }

    @PostMapping("/")
    public ResponseEntity<BookDTO> saveBook(@RequestBody @Valid BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.saveBook(bookDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) throws Exception {
        return bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long id) throws Exception {
        return bookService.updateBook(bookDTO, id);
    }
}
