package com.mindex.challenge.service.impl;

import com.mindex.challenge.model.Employee;
import com.mindex.challenge.repository.EmployeeRepository;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setDirectReports(employee.getDirectReports());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
