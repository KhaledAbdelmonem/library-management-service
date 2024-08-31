package com.example.librarymanagementservice.repository;

import com.example.librarymanagementservice.entity.Book;
import com.example.librarymanagementservice.entity.BorrowingRecord;
import com.example.librarymanagementservice.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long> {
    Optional<BorrowingRecord> findByBookAndPatronAndReturnDateIsNull(Book book, Patron patron);
}
