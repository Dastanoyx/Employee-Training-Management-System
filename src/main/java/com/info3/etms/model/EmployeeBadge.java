package com.info3.etms.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_badge")
public class EmployeeBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, columnDefinition = "BIGINT")
    private Employee employee;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String badgeNumber;

}

