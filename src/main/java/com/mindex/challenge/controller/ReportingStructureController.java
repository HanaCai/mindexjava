package com.mindex.challenge.controller;

import com.mindex.challenge.model.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporting-structure")
public class ReportingStructureController {

    @Autowired
    private ReportingStructureService reportingStructureService;


    @GetMapping("/employee/{employeeId}")
    public ReportingStructure getByEmployeeId(@PathVariable String employeeId) {
        return reportingStructureService.getByEmployeeId(employeeId);
    }

}
