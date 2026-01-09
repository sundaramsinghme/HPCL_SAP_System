package com.example.SYP_System.dto.cylinderDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.SYP_System.enums.CylinderStatus;

public record CylinderResponseDTO(
        Long id,
        Long serialNo,
        LocalDate mfgDate,
        LocalDate testDueDate,
        String lastInvoiceNo,
        CylinderStatus status,
        String batch,
        String testReportNo,
        LocalDate validTill,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
