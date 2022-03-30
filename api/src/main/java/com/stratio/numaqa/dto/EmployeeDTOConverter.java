package com.stratio.numaqa.dto;


import com.stratio.numaqa.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class EmployeeDTOConverter {
    private final ModelMapper modelMapper;

    public EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

}
