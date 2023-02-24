/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel.querytest.api.controllers;

import com.myhotel.querytest.application.queries.ReadAvgSalaryByDepartmentQuery;
import com.myhotel.querytest.application.queries.ReadEmployeeDepartmentMaxSalaryQuery;
import com.myhotel.querytest.application.queries.ReadEmployeeSegmentDepartmentQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myhotel.querytest.application.queries.ReadEmployeeSegmentQuery;
import com.myhotel.querytest.application.queries.ReadInfoPerCountryQuery;
import com.myhotel.querytest.application.queries.ReadManagerInfoQuery;

import io.jkratz.mediator.core.Mediator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/query-api")
public class QueriesController {

    private static final Logger logger = LoggerFactory.getLogger(QueriesController.class);
    private static final String LOG_MESSAGE="------ Sending command: {} ";

    @Autowired
    private Mediator mediator;

    //Pregunta 1
    @GetMapping("/segments/{segment}")
    public ResponseEntity<Object> getEmployeeSegment(@PathVariable(name = "segment") String segment) {

        var query = new ReadEmployeeSegmentQuery(segment);
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    //Pregunta 2
    @GetMapping("/segments/departments/{segment}")
    public ResponseEntity<Object> getEmployeeSegmentDepartments(@PathVariable(name = "segment") String segment) {

        var query = new ReadEmployeeSegmentDepartmentQuery(segment);
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    //Pregunta 3
    @GetMapping("/departments/employees/maxsalary")
    public ResponseEntity<Object> getDepartmentsEmployeeMaxSalary() {

        var query = new ReadEmployeeDepartmentMaxSalaryQuery();
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    //Pregunta 4
    @GetMapping("/employees/managers")
    public ResponseEntity<Object> getDepartmentsEmployeeMaxSalary(@RequestParam Integer years) {

        var query = new ReadManagerInfoQuery(years);
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    //Pregunta 5
    @GetMapping("/departments/averagesalaries")
    public ResponseEntity<Object> getDepartmentsAvgSalaries(@RequestParam Integer employees) {

        var query = new ReadAvgSalaryByDepartmentQuery(employees);
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

    //Pregunta 6
    @GetMapping("/countries")
    public ResponseEntity<Object> getCountriesInfo() {

        var query = new ReadInfoPerCountryQuery();
        logger.info(LOG_MESSAGE, query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

}
