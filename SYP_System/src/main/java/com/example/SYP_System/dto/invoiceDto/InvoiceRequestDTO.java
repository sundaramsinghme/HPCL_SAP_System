package com.example.SYP_System.dto.invoiceDto;

public record InvoiceRequestDTO(
        Long serialNo,
        String invoiceNo,
        Double rate,
        Double amount
) { }
