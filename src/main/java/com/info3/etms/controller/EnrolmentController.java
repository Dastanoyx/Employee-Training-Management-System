package com.info3.etms.controller;

import com.info3.etms.dto.EnrolmentRequest;
import com.info3.etms.model.Enrolment;
import com.info3.etms.service.EnrolmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @PostMapping
    public ResponseEntity<Enrolment> enrollEmployee(@RequestBody EnrolmentRequest request) {
        Enrolment enrolment = enrolmentService.enrollEmployee(request.getEmployeeId(), request.getTrainingId());
        return ResponseEntity.status(201).body(enrolment);
    }

    @DeleteMapping("/{employeeId}/{trainingId}")
    public ResponseEntity<Void> exitTraining(@PathVariable Long employeeId, @PathVariable Long trainingId) {
        enrolmentService.exitTraining(employeeId, trainingId);
        return ResponseEntity.noContent().build();
    }
}
