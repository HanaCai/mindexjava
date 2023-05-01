package com.mindex.challenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mindex.challenge.model.Compensation;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    Compensation findByEmployeeId(String employeeId);
}
