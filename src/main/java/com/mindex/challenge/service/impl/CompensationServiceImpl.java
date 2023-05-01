package com.mindex.challenge.service.impl;

import com.mindex.challenge.model.Compensation;
import com.mindex.challenge.repository.CompensationRepository;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation createCompensation(Compensation compensation) {
        return compensationRepository.save(compensation);
    }

    @Override
    public Compensation findByEmployeeId(String employeeId) {
        Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }
        return compensation;
    }
}
