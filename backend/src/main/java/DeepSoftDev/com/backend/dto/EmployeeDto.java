package DeepSoftDev.com.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long Id; //Long was the issue here
    private String FirstName;
    private String LastName;
    private String email;

}
