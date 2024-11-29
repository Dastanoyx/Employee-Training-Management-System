package com.info3.etms.service;

import com.info3.etms.model.Enrolment;

public interface EnrolmentService {
    Enrolment enrollEmployee(Long employeeId, Long trainingId);

    void exitTraining(Long employeeId, Long trainingId);
}
