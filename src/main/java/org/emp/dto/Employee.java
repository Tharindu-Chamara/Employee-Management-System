package org.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String departmentId;
    private String roleId;

}
