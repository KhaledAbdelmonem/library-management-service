package com.example.librarymanagementservice.service;

import com.example.librarymanagementservice.dto.BorrowingRecordDTO;

public interface BorrowingRecordService {

    public BorrowingRecordDTO borrowBook(Long bookId, Long patronId) throws Exception;

    public BorrowingRecordDTO returnBook(Long bookId, Long patronId, BorrowingRecordDTO recordDTO) throws Exception;

}
