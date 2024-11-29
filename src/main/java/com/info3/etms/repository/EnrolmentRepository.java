package com.info3.etms.repository;

import com.info3.etms.model.Enrolment;
import com.info3.etms.model.EnrolmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment, EnrolmentId> {
}
