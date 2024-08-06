package DeepSoftDev.com.backend.controller;

import DeepSoftDev.com.backend.dto.EmployeeDto;
import DeepSoftDev.com.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Built Add Employee Rest API
@PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
         EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long employeeId){
    EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
    return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee Rest API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
   EmployeeDto employeeDto =  employeeService.updateEmployee(employeeId,updatedEmployee);
   return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    //Build for deleting employee using Employee ID
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee deleted successfully!");

    }
}
