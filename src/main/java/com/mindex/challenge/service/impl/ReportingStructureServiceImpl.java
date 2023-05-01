package com.mindex.challenge.service.impl;

import com.mindex.challenge.model.Employee;
import com.mindex.challenge.model.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure getByEmployeeId(String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }

        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports(this.calculateReports(employee));
        return reportingStructure;
    }

    private int calculateReports(Employee employee) {
        if (employee.getDirectReports() == null || employee.getDirectReports().isEmpty()) {
            return 0;
        }

        int numberOfReports = 0;
        for (String employeeId : employee.getDirectReports()) {
            numberOfReports++;
            Employee emp = employeeService.getEmployeeById(employeeId);
            numberOfReports += this.calculateReports(emp);
        }
        return numberOfReports;
    }

}
