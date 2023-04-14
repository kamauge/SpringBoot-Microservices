package com.amg.departmentservice.service.impl;

import com.amg.departmentservice.dto.DepartmentDto;
import com.amg.departmentservice.repository.DepartmentRepository;
import com.amg.departmentservice.service.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentImpl implements Department {

    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return null;
    }
}
