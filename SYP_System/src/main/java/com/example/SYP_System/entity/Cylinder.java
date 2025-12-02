package com.example.SYP_System.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.SYP_System.enums.CylinderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cylinder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cylinder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long serialNo;

    private LocalDate mfgDate;

    private LocalDate testDueDate;

    private String lastInvoiceNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CylinderStatus status;

    @Column(length = 50)
    private String batch;

    private String testReportNo;

    private LocalDate validTill;

    @OneToMany(mappedBy = "cylinder", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
