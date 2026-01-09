package com.example.SYP_System.service;

import java.util.List;

import com.example.SYP_System.dto.invoiceDto.InvoiceRequestDTO;
import com.example.SYP_System.dto.invoiceDto.InvoiceResponseDTO;

public interface InvoiceService {

    InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto);

    InvoiceResponseDTO getInvoiceByInvoiceNO(String invoiceNo);

    List<InvoiceResponseDTO> getAllInvoices();

    List<InvoiceResponseDTO> getInvoiceBySerialNo(Long serialno);

    InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO dto);

    void deleteInvoice(Long id);
}
