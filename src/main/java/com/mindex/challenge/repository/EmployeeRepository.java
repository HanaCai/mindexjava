package com.mindex.challenge.repository;

import org.springframework.stereotype.Repository;

import com.mindex.challenge.model.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
