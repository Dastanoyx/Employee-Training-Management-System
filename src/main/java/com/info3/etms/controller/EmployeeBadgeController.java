package com.info3.etms.controller;

import com.info3.etms.model.EmployeeBadge;
import com.info3.etms.service.EmployeeBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-badges")
public class EmployeeBadgeController {

    private final EmployeeBadgeService employeeBadgeService;

    @Autowired
    public EmployeeBadgeController(EmployeeBadgeService employeeBadgeService) {
        this.employeeBadgeService = employeeBadgeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeBadge> createEmployeeBadge(@RequestBody EmployeeBadge employeeBadge, @RequestParam Long employeeId) {
        EmployeeBadge createdBadge = employeeBadgeService.createEmployeeBadge(employeeBadge, employeeId);
        return ResponseEntity.ok(createdBadge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeBadge> updateEmployeeBadge(@PathVariable Long id, @RequestBody EmployeeBadge employeeBadge, @RequestParam Long employeeId) {
        EmployeeBadge updatedBadge = employeeBadgeService.updateEmployeeBadge(id, employeeBadge, employeeId);
        return ResponseEntity.ok(updatedBadge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeBadge> getEmployeeBadgeById(@PathVariable Long id) {
        return employeeBadgeService.getEmployeeBadgeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeBadge>> getAllEmployeeBadges() {
        List<EmployeeBadge> badges = employeeBadgeService.getAllEmployeeBadges();
        return ResponseEntity.ok(badges);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeBadge(@PathVariable Long id) {
        employeeBadgeService.deleteEmployeeBadge(id);
        return ResponseEntity.noContent().build();
    }
}


