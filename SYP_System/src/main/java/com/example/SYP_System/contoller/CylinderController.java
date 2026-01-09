package com.example.SYP_System.contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SYP_System.dto.ApiResponse;
import com.example.SYP_System.dto.cylinderDto.CylinderRequestDTO;
import com.example.SYP_System.dto.cylinderDto.CylinderResponseDTO;
import com.example.SYP_System.service.CylinderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cylinders")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174",  "https://hpclsparesportal.in"})
public class CylinderController {

    private final CylinderService cylinderService;

    // Create Cylinder
    @PostMapping
    public ResponseEntity<ApiResponse<CylinderResponseDTO>> createCylinder(@RequestBody CylinderRequestDTO dto) {
        CylinderResponseDTO saved = cylinderService.saveCylinder(dto);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinder created successfully", saved));
    }

    // Get All Cylinders
    @GetMapping
    public ResponseEntity<ApiResponse<List<CylinderResponseDTO>>> getAllCylinders() {
        List<CylinderResponseDTO> list = cylinderService.getAllCylinders();
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinders fetched successfully", list));
    }

    // Get Cylinder by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CylinderResponseDTO>> getCylinderById(@PathVariable("id") Long id) {
        CylinderResponseDTO dto = cylinderService.getCylinderById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinder fetched successfully", dto));
    }

    // Get Cylinder by Serial No
    @GetMapping("/serial/{serialNo}")
    public ResponseEntity<ApiResponse<CylinderResponseDTO>> getCylinderBySerialNo(@PathVariable("serialNo") Long serialNo) {
        CylinderResponseDTO dto = cylinderService.getBySerialNo(serialNo);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinder fetched successfully", dto));
    }

    // Update Cylinder
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CylinderResponseDTO>> updateCylinder(
            @PathVariable("id") Long id,
            @RequestBody CylinderRequestDTO dto) {

        CylinderResponseDTO updated = cylinderService.updateCylinder(id, dto);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinder updated successfully", updated));
    }

    // Delete Cylinder
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCylinder(@PathVariable("id") Long id) {
        cylinderService.deleteCylinder(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Cylinder deleted successfully", null));
    }
}
