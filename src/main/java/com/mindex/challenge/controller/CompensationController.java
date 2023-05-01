package com.mindex.challenge.controller;

import com.mindex.challenge.model.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compensation")
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    @PostMapping("")
    public Compensation createCompensation(@RequestBody Compensation compensation) {
        return compensationService.createCompensation(compensation);
    }

    @GetMapping("/employee/{employeeId}")
    public Compensation findByEmployeeId(@PathVariable String employeeId) {
        return compensationService.findByEmployeeId(employeeId);
    }

}
