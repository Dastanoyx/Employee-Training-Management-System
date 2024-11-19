package com.info3.etms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "enrolment")
public class Enrolment {

    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("employeeId") // Maps the employeeId part of the composite key
    @JoinColumn(
            name = "employee_id",
            foreignKey = @ForeignKey(name = "enrolment_employee_id_fk"),
            nullable = false
    )
    private Employee employee;

    @ManyToOne
    @MapsId("trainingId") // Maps the trainingId part of the composite key
    @JoinColumn(
            name = "training_id",
            foreignKey = @ForeignKey(name = "enrolment_training_id_fk"),
            nullable = false
    )
    private Training training;

    @Column(
            name = "enrolled_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime enrolledAt;
}
