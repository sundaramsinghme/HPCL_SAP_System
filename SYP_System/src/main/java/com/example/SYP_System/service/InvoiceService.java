package com.example.SYP_System.service;

import java.util.List;

import com.example.SYP_System.dto.invoiceDto.InvoiceRequestDTO;
import com.example.SYP_System.dto.invoiceDto.InvoiceResponseDTO;

public interface InvoiceService {

    InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto);

    InvoiceResponseDTO getInvoiceById(Long id);

    List<InvoiceResponseDTO> getAllInvoices();

    List<InvoiceResponseDTO> getInvoiceBySerialNo(Long serialno);

    InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO dto);

    void deleteInvoice(Long id);
}
