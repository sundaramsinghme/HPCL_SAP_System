package com.example.SYP_System.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SYP_System.dto.cylinderDto.CylinderRequestDTO;
import com.example.SYP_System.dto.cylinderDto.CylinderResponseDTO;
import com.example.SYP_System.entity.Cylinder;
import com.example.SYP_System.repository.CylinderRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CylinderServiceImpl implements CylinderService {

    private final CylinderRepo cylinderRepository;

    // Convert DTO → Entity
    private Cylinder mapToEntity(CylinderRequestDTO dto) {
        return Cylinder.builder()
                .serialNo(dto.serialNo())
                .mfgDate(dto.mfgDate())
                .testDueDate(dto.testDueDate())
                .lastInvoiceNo(dto.lastInvoice())
                .status(dto.status())
                .batch(dto.batch())
                .testReportNo(dto.testReportNo())
                .validTill(dto.validTill())
                .build();
    }

    // Convert Entity → DTO
    private CylinderResponseDTO mapToDTO(Cylinder entity) {
        return new CylinderResponseDTO(
                entity.getId(),
                entity.getSerialNo(),
                entity.getMfgDate(),
                entity.getTestDueDate(),
                entity.getLastInvoiceNo(),
                entity.getStatus(),
                entity.getBatch(),
                entity.getTestReportNo(),
                entity.getValidTill(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }

    // Save Cylinder
    @Override
    public CylinderResponseDTO saveCylinder(CylinderRequestDTO dto) {

        if (cylinderRepository.existsBySerialNo(dto.serialNo())) {
            throw new RuntimeException("Cylinder with this serial number already exists.");
        }

        Cylinder saved = cylinderRepository.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    // Get All Cylinders
    @Override
    public List<CylinderResponseDTO> getAllCylinders() {
        return cylinderRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    // Get by ID
    @Override
    public CylinderResponseDTO getCylinderById(Long id) {
        Cylinder cylinder = cylinderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cylinder not found"));

        return mapToDTO(cylinder);
    }

    // Update Cylinder
    @Override
    public CylinderResponseDTO updateCylinder(Long id, CylinderRequestDTO dto) {
        Cylinder existing = cylinderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cylinder not found"));

        if (dto.batch() != null) {
            existing.setBatch(dto.batch());
        }
        if (dto.mfgDate() != null) {
            existing.setMfgDate(dto.mfgDate());
        }
        if (dto.testDueDate() != null) {
            existing.setTestDueDate(dto.testDueDate());
        }
        if (dto.testReportNo() != null) {
            existing.setTestReportNo(dto.testReportNo());
        }
        if (dto.validTill() != null) {
            existing.setValidTill(dto.validTill());
        }
        if (dto.status() != null) {
            existing.setStatus(dto.status());
        }
        if (dto.lastInvoice() != null) {
            existing.setLastInvoiceNo(dto.lastInvoice());
        }
        if (dto.serialNo() != null) {
            existing.setSerialNo(dto.serialNo());
        }

        Cylinder updated = cylinderRepository.save(existing);
        return mapToDTO(updated);
    }

    // Delete Cylinder
    @Override
    public void deleteCylinder(Long id) {
        Cylinder cylinder = cylinderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cylinder not found"));
        cylinderRepository.delete(cylinder);
    }

    // Get by Serial No
    @Override
    public CylinderResponseDTO getBySerialNo(Long serialNo) {
        Cylinder cylinder = cylinderRepository.findBySerialNo(serialNo)
                .orElseThrow(() -> new RuntimeException("Cylinder not found"));
        return mapToDTO(cylinder);
    }
}
