package org.emp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class EmployeeServideImpl implements EmployeeService {


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
           employeeList.add(mapper.convertValue(entity,Employee.class));
        });
        return  employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            repository.save(mapper.convertValue(employee,EmployeeEntity.class));

        }
    }

    @Override
    public Employee findById(Long id) {
        if(repository.findById(id).isPresent()){
            Optional<EmployeeEntity> byId = repository.findById(id);
              return  mapper.convertValue(byId.get(),Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findByFirstname(String firstname) {
      return  mapper.convertValue(repository.findByFirstname(firstname),Employee.class) ;
    }

}
