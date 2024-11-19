package com.info3.etms.service;

import com.info3.etms.model.EmployeeBadge;

import java.util.List;
import java.util.Optional;

public interface EmployeeBadgeService {
    EmployeeBadge createEmployeeBadge(EmployeeBadge employeeBadge, Long employeeId);

    EmployeeBadge updateEmployeeBadge(Long id, EmployeeBadge employeeBadge, Long employeeId);

    Optional<EmployeeBadge> getEmployeeBadgeById(Long id);

    List<EmployeeBadge> getAllEmployeeBadges();

    void deleteEmployeeBadge(Long id);
}

