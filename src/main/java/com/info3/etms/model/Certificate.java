package com.info3.etms.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, columnDefinition = "BIGINT")
    private Employee employee;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String certificateName;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime issuedAt;

}
