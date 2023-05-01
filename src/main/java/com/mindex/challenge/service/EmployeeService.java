package com.mindex.challenge.service;

import com.mindex.challenge.model.Employee;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(String id);
    public Employee updateEmployee(String id, Employee employee);
    public void deleteEmployee(String id);
}
