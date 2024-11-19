package com.info3.etms.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String position;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeBadge employeeBadge;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Enrolment> enrolments;
}
