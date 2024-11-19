package com.info3.etms.service.impl;

import com.info3.etms.mapper.EmployeeBadgeMapper;
import com.info3.etms.model.Employee;
import com.info3.etms.model.EmployeeBadge;
import com.info3.etms.repository.EmployeeBadgeRepository;
import com.info3.etms.repository.EmployeeRepository;
import com.info3.etms.service.EmployeeBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeBadgeServiceImpl implements EmployeeBadgeService {

    private final EmployeeBadgeRepository employeeBadgeRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeBadgeMapper employeeBadgeMapper;

    @Autowired
    public EmployeeBadgeServiceImpl(EmployeeBadgeRepository employeeBadgeRepository,
                                    EmployeeRepository employeeRepository,
                                    EmployeeBadgeMapper employeeBadgeMapper) {
        this.employeeBadgeRepository = employeeBadgeRepository;
        this.employeeRepository = employeeRepository;
        this.employeeBadgeMapper = employeeBadgeMapper;
    }

    @Override
    public EmployeeBadge createEmployeeBadge(EmployeeBadge employeeBadge, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        employeeBadge.setEmployee(employee);
        employee.setEmployeeBadge(employeeBadge);

        return employeeBadgeRepository.save(employeeBadge);
    }

    @Override
    public EmployeeBadge updateEmployeeBadge(Long id, EmployeeBadge employeeBadge, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        return employeeBadgeRepository.findById(id).map(existingBadge -> {
            employeeBadgeMapper.updateEmployeeBadgeFromDto(employeeBadge, existingBadge);
            existingBadge.setEmployee(employee);
            employee.setEmployeeBadge(existingBadge);
            return employeeBadgeRepository.save(existingBadge);
        }).orElseThrow(() -> new RuntimeException("EmployeeBadge not found with ID: " + id));
    }

    @Override
    public Optional<EmployeeBadge> getEmployeeBadgeById(Long id) {
        return employeeBadgeRepository.findById(id);
    }

    @Override
    public List<EmployeeBadge> getAllEmployeeBadges() {
        return employeeBadgeRepository.findAll();
    }

    @Override
    public void deleteEmployeeBadge(Long id) {
        if (employeeBadgeRepository.existsById(id)) {
            employeeBadgeRepository.deleteById(id);
        } else {
            throw new RuntimeException("EmployeeBadge not found with ID: " + id);
        }
    }
}


