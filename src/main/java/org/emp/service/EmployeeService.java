package org.emp.service;

import org.emp.dto.Employee;


import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    public List<Employee> getAll();

    void deleteEmployeeById(Long id);

    void updateEmployee(Employee employee);

    Employee findById(Long id);

    Employee findByFirstname(String firstname);
}
