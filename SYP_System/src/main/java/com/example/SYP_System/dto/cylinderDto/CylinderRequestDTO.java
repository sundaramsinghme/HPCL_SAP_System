package com.example.SYP_System.dto.cylinderDto;

import java.time.LocalDate;

import com.example.SYP_System.enums.CylinderStatus;

public record CylinderRequestDTO(
        Long serialNo,
        LocalDate mfgDate,
        LocalDate testDueDate,
        String lastInvoice,
        CylinderStatus status,
        String batch,
        String testReportNo,
        LocalDate validTill) {
}
