package com.example.librarymanagementservice.service.impl;

import com.example.librarymanagementservice.dto.BookDTO;
import com.example.librarymanagementservice.entity.Book;
import com.example.librarymanagementservice.exceptin.MismatchedDataException;
import com.example.librarymanagementservice.exceptin.ObjectNotFoundException;
import com.example.librarymanagementservice.repository.BookRepo;
import com.example.librarymanagementservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<BookDTO> getAllBooks() {
        return BookDTO.listToDTO(bookRepo.findAll());
    }

    public BookDTO getBook(Long id) throws Exception {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            throw new ObjectNotFoundException("Book not found!");
        }
        return BookDTO.toDto(book);
    }

    public BookDTO saveBook(BookDTO bookDto) {
        return BookDTO.toDto(bookRepo.save(BookDTO.toEntity(bookDto)));
    }

    public String deleteBook(Long id) throws Exception {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            throw new ObjectNotFoundException("Book not found!");
        }
        bookRepo.deleteById(id);
        return "Book deleted Successfully";
    }

    @Override
    public BookDTO updateBook(BookDTO bookDto, Long bookId) throws Exception {
        if (bookDto.getId() != null && bookDto.getId() != bookId) {
            throw new MismatchedDataException("Mismatch book id!");
        }
        Book book = bookRepo.findById(bookId).orElse(null);
        if (book == null) {
            throw new ObjectNotFoundException("Book not found!");
        }
        bookDto.setId(bookId);
        book = BookDTO.toEntity(bookDto);
        bookRepo.save(book);

        return bookDto;
    }
}


