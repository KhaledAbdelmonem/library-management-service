package com.example.librarymanagementservice.repository;

import com.example.librarymanagementservice.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Long> {

}
