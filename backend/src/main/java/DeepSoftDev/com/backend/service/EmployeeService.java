package DeepSoftDev.com.backend.service;

import DeepSoftDev.com.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(long employeeId);

}
