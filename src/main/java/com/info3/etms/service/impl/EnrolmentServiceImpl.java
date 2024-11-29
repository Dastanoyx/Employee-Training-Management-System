package com.info3.etms.service.impl;

import com.info3.etms.exception.ConflictException;
import com.info3.etms.exception.ResourceNotFoundException;
import com.info3.etms.model.Enrolment;
import com.info3.etms.model.EnrolmentId;
import com.info3.etms.model.Employee;
import com.info3.etms.model.Training;
import com.info3.etms.repository.EnrolmentRepository;
import com.info3.etms.repository.EmployeeRepository;
import com.info3.etms.repository.TrainingRepository;
import com.info3.etms.service.EnrolmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;
    private final EmployeeRepository employeeRepository;
    private final TrainingRepository trainingRepository;

    public EnrolmentServiceImpl(EnrolmentRepository enrolmentRepository,
                                EmployeeRepository employeeRepository,
                                TrainingRepository trainingRepository) {
        this.enrolmentRepository = enrolmentRepository;
        this.employeeRepository = employeeRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Enrolment enrollEmployee(Long employeeId, Long trainingId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID " + employeeId));
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new ResourceNotFoundException("Training not found with ID " + trainingId));

        EnrolmentId enrolmentId = new EnrolmentId(employeeId, trainingId);
        if (enrolmentRepository.existsById(enrolmentId)) {
            throw new ConflictException("Employee with ID " + employeeId + " is already enrolled in Training with ID " + trainingId);
        }

        Enrolment enrolment = new Enrolment();
        enrolment.setId(enrolmentId);
        enrolment.setEmployee(employee);
        enrolment.setTraining(training);
        enrolment.setEnrolledAt(LocalDateTime.now());

        return enrolmentRepository.save(enrolment);
    }

    @Override
    public void exitTraining(Long employeeId, Long trainingId) {
        EnrolmentId enrolmentId = new EnrolmentId(employeeId, trainingId);
        if (!enrolmentRepository.existsById(enrolmentId)) {
            throw new ResourceNotFoundException("Enrolment not found for Employee ID " + employeeId + " and Training ID " + trainingId);
        }
        enrolmentRepository.deleteById(enrolmentId);
    }
}
