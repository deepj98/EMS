package DeepSoftDev.com.backend.service.impl;

import DeepSoftDev.com.backend.dto.EmployeeDto;
import DeepSoftDev.com.backend.entity.Employee;
import DeepSoftDev.com.backend.exception.ResourceNotFound;
import DeepSoftDev.com.backend.mapper.EmployeeMapper;
import DeepSoftDev.com.backend.repository.EmployeeRepository;
import DeepSoftDev.com.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFound("Employee does not exists with given Id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFound("Employee not found : " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj  = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFound("Employee not found : " + employeeId)
        );
        employeeRepository.deleteById(employeeId);

    }
}
