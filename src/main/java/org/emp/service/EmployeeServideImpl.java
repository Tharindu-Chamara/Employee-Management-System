package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServideImpl implements EmployeeService {


    final EmployeeRepository repository;


    final ObjectMapper mapper;

    @Override
    public void addEmployee(Employee employee) {

        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class) ;
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> employeeList= new ArrayList<>();

        List<EmployeeEntity> allEntityList = repository.findAll();

        allEntityList.forEach(entity -> {
           employeeList.add(mapper.convertValue(entity,Employee.class))
        });
       return  employeeList;
    }
}
