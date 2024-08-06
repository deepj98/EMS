package DeepSoftDev.com.backend.repository;

import DeepSoftDev.com.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
