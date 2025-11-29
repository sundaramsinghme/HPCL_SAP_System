package com.example.SYP_System.dto.invoiceDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InvoiceResponseDTO(
        Long id,
        Long serialNo,
        String invoiceNo,
        Double rate,
        Double amount,
        Long cylinderId,
        LocalDate invoiceDate,
        LocalDateTime updatedAt) {
}
