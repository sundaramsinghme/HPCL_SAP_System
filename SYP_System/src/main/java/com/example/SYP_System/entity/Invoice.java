package com.example.SYP_System.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long serialNo;

    @Column(nullable = false, unique = true)
    private String invoiceNo;

    @Column(nullable = false)
    private Double rate;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "cylinder_id")
    private Cylinder cylinder;

    @CreationTimestamp
    private LocalDate invoiceDate;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
