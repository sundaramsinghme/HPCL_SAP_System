package com.example.SYP_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SYP_System.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

    // Find invoice by invoice number
    Invoice findByInvoiceNo(String invoiceNo);

    boolean existsByInvoiceNo(String invoiceNo);

    // Find invoices by serialNo (if you still want it)
    List<Invoice> findBySerialNo(Long serialNo);

    // Find all invoices associated with a cylinder
    List<Invoice> findByCylinder_Id(Long cylinderId);

}
