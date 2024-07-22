package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

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
    public List<EmployeeEntity> getAll() {
      return repository.findAll();

    }
}
