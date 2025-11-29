package com.example.SYP_System.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SYP_System.dto.invoiceDto.InvoiceRequestDTO;
import com.example.SYP_System.dto.invoiceDto.InvoiceResponseDTO;
import com.example.SYP_System.entity.Cylinder;
import com.example.SYP_System.entity.Invoice;
import com.example.SYP_System.repository.CylinderRepo;
import com.example.SYP_System.repository.InvoiceRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final CylinderRepo cylinderRepo;

    private InvoiceResponseDTO mapToDTO(Invoice invoice) {
        return new InvoiceResponseDTO(
                invoice.getId(),
                invoice.getSerialNo(),
                invoice.getInvoiceNo(),
                invoice.getRate(),
                invoice.getAmount(),
                invoice.getCylinder() != null ? invoice.getCylinder().getId() : null,
                invoice.getInvoiceDate(),
                invoice.getUpdatedAt());
    }

    @Override
    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto) {

        if (invoiceRepo.existsByInvoiceNo(dto.invoiceNo())) {
            throw new RuntimeException("Invoice number already exists");
        }

        Cylinder cylinder = cylinderRepo.findBySerialNo(dto.serialNo())
                .orElseThrow(() -> new RuntimeException("Cylinder not found"));

        Invoice invoice = Invoice.builder()
                .serialNo(dto.serialNo())
                .invoiceNo(dto.invoiceNo())
                .rate(dto.rate())
                .amount(dto.amount())
                .cylinder(cylinder)
                .build();

        Invoice saved = invoiceRepo.save(invoice);

        // seting the last invoice no of cylinder
        cylinder.setLastInvoiceNo(dto.invoiceNo());
        cylinderRepo.save(cylinder);

        return mapToDTO(saved);
    }

    @Override
    public InvoiceResponseDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return mapToDTO(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> getInvoiceBySerialNo(Long serialno) {
        return invoiceRepo.findBySerialNo(serialno).stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepo.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO dto) {
        Invoice existing = invoiceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        if (dto.serialNo() != null)
            existing.setSerialNo(dto.serialNo());
        if (dto.invoiceNo() != null)
            existing.setInvoiceNo(dto.invoiceNo());
        if (dto.rate() != null)
            existing.setRate(dto.rate());
        if (dto.amount() != null)
            existing.setAmount(dto.amount());

        if (dto.serialNo() != null) {
            Cylinder cylinder = cylinderRepo.findBySerialNo(dto.serialNo())
                    .orElseThrow(() -> new RuntimeException("Cylinder not found"));
            existing.setCylinder(cylinder);
        }
        ;

        Invoice updated = invoiceRepo.save(existing);
        return mapToDTO(updated);
    }

    @Override
    public void deleteInvoice(Long id) {
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepo.delete(invoice);
    }
}
