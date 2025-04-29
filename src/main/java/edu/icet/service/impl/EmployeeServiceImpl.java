package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> all = repository.findAll();

        all.forEach(employeeEntity ->
                employeeList.add(mapper.map(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        repository.save(mapper.map(employee, EmployeeEntity.class));
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
