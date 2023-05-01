package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.model.Employee;
import com.mindex.challenge.repository.EmployeeRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private DataBootstrap dataBootstrap;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        employeeRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void test() throws IOException {
        // Call the init method
        dataBootstrap.init();

        // Verify that the employee data was loaded from the JSON file and saved to the repository
        InputStream inputStream = getClass().getResourceAsStream(DataBootstrap.DATASTORE_LOCATION);
        Employee[] employees = objectMapper.readValue(inputStream, Employee[].class);

        List<Employee> employeesFromRepo = employeeRepository.findAll();

        assertEquals(employees.length, employeesFromRepo.size(), "The number of employees should match the JSON file");

        for (int i = 0; i < employees.length; i++) {
            Employee expectedEmployee = employees[i];
            Employee actualEmployee = employeesFromRepo.get(i);

            assertNotNull(actualEmployee.getEmployeeId(), "The employee ID should not be null");
            assertEquals(expectedEmployee.getFirstName(), actualEmployee.getFirstName(), "The first names should match");
            assertEquals(expectedEmployee.getLastName(), actualEmployee.getLastName(), "The last names should match");
            assertEquals(expectedEmployee.getDepartment(), actualEmployee.getDepartment(), "The departments should match");
            assertEquals(expectedEmployee.getPosition(), actualEmployee.getPosition(), "The positions should match");
        }
    }
}