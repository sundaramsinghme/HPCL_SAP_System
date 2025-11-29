package com.example.SYP_System.service;

import java.util.List;

import com.example.SYP_System.dto.cylinderDto.CylinderRequestDTO;
import com.example.SYP_System.dto.cylinderDto.CylinderResponseDTO;

public interface CylinderService {

    CylinderResponseDTO saveCylinder(CylinderRequestDTO dto);

    List<CylinderResponseDTO> getAllCylinders();

    CylinderResponseDTO getCylinderById(Long id);

    CylinderResponseDTO updateCylinder(Long id, CylinderRequestDTO dto);

    void deleteCylinder(Long id);

    CylinderResponseDTO getBySerialNo(Long serialNo);
}
