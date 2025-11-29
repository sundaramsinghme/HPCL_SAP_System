package com.example.SYP_System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SYP_System.entity.Cylinder;

public interface CylinderRepo extends JpaRepository<Cylinder, Long> {

    // Find cylinder by serial number
    Optional<Cylinder> findBySerialNo(Long serialNo);

    // Check if cylinder exists
    boolean existsBySerialNo(Long serialNo);

}
