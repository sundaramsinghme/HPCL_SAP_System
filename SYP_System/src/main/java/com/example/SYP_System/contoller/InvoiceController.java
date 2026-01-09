package com.example.SYP_System.contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SYP_System.dto.ApiResponse;
import com.example.SYP_System.dto.invoiceDto.InvoiceRequestDTO;
import com.example.SYP_System.dto.invoiceDto.InvoiceResponseDTO;
import com.example.SYP_System.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:5173", "http://localhost:5174", "https://hpclsparesportal.in" })
public class InvoiceController {

        private final InvoiceService invoiceService;

        // Create Invoice
        @PostMapping()
        public ResponseEntity<ApiResponse<InvoiceResponseDTO>> createInvoice(
                        @RequestBody InvoiceRequestDTO dto) {

                InvoiceResponseDTO created = invoiceService.createInvoice(dto);

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoice created successfully",
                                                created));
        }

        // Get All Invoices
        @GetMapping
        public ResponseEntity<ApiResponse<List<InvoiceResponseDTO>>> getAllInvoices() {

                List<InvoiceResponseDTO> list = invoiceService.getAllInvoices();

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoices fetched successfully",
                                                list));
        }

        // Get Invoice by invoice No
        @GetMapping("/{invoiceNo}")
        public ResponseEntity<ApiResponse<InvoiceResponseDTO>> getInvoiceByInoviceNo(
                        @PathVariable("invoiceNo") String invoiceNo) {

                InvoiceResponseDTO dto = invoiceService.getInvoiceByInvoiceNO(invoiceNo);

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoice fetched successfully",
                                                dto));
        }

        // get invoices by cylinder serial no
        @GetMapping("/cylinder/serialno/{serialno}")
        public ResponseEntity<ApiResponse<List<InvoiceResponseDTO>>> getInvoiceBySerialNo(@PathVariable("serialno") Long serialno) {

                List<InvoiceResponseDTO> list = invoiceService.getInvoiceBySerialNo(serialno);

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoices fetched successfully",
                                                list));
        }

        // Update Invoice
        @PutMapping("/{id}")
        public ResponseEntity<ApiResponse<InvoiceResponseDTO>> updateInvoice(
                        @PathVariable("id") Long id,
                        @RequestBody InvoiceRequestDTO dto) {

                InvoiceResponseDTO updated = invoiceService.updateInvoice(id, dto);

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoice updated successfully",
                                                updated));
        }

        // Delete Invoice
        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse<String>> deleteInvoice(@PathVariable("id") Long id) {

                invoiceService.deleteInvoice(id);

                return ResponseEntity.ok(
                                new ApiResponse<>(
                                                true,
                                                "Invoice deleted successfully",
                                                null));
        }
}
