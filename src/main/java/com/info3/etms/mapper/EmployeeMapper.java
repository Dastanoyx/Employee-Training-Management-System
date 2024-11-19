package com.info3.etms.mapper;

import com.info3.etms.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    void updateEmployeeFromDto(Employee source, @MappingTarget Employee target);
}

