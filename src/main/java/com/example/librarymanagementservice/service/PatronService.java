package com.example.librarymanagementservice.service;


import com.example.librarymanagementservice.dto.PatronDTO;

import java.util.List;

public interface PatronService {
    public List<PatronDTO> getAllPatrons();

    public PatronDTO getPatron(Long id) throws Exception;

    public PatronDTO savePatron(PatronDTO patronDTO);

    public String deletePatron(Long id) throws Exception;

    public PatronDTO updatePatron(PatronDTO patronDTO, Long patronId) throws Exception;
}
