package com.example.librarymanagementservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private LocalDate publisher_date;

    private boolean borrowed;

    @Column(name = "Created")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "book")
    private List<BorrowingRecord> borrowingRecords;

}
