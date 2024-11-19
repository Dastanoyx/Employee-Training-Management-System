package com.info3.etms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolmentId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "training_id")
    private Long trainingId;

    public EnrolmentId(Long employeeId, Long trainingId) {
        this.employeeId = employeeId;
        this.trainingId = trainingId;
    }

    public EnrolmentId() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(trainingId, that.trainingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, trainingId);
    }
}
