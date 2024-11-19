package com.info3.etms.mapper;

import com.info3.etms.model.EmployeeBadge;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeBadgeMapper {
    void updateEmployeeBadgeFromDto(EmployeeBadge source, @MappingTarget EmployeeBadge target);
}

