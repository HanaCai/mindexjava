package com.mindex.challenge.service;

import com.mindex.challenge.model.Compensation;

public interface CompensationService {
    public Compensation createCompensation(Compensation compensation);
    public Compensation findByEmployeeId(String employeeId);
}
