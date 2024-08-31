package com.example.librarymanagementservice.service;

import com.example.librarymanagementservice.dto.BookDTO;

import java.util.List;

public interface BookService {

    public List<BookDTO> getAllBooks();

    public BookDTO getBook(Long id) throws Exception;

    public BookDTO saveBook(BookDTO bookDto);

    public String deleteBook(Long id) throws Exception;

    public BookDTO updateBook(BookDTO bookDto, Long bookId) throws Exception;

}
