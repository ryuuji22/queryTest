/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.querytest.infraestructure.repositories;

import com.myhotel.querytest.domain.entities.BaseCountry;
import com.myhotel.querytest.domain.entities.DepartmentAvgSalary;
import com.myhotel.querytest.domain.entities.EmployeeInfo;
import com.myhotel.querytest.domain.entities.EmployeeSegmentCount;
import com.myhotel.querytest.domain.entities.EmployeeSegmentDepartmentCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;
import com.myhotel.querytest.infraestructure.repositories.jpa.IJpaGeneralRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author diego
 */
@Repository
public class GeneralRepository implements IGeneralRepository {

    @Autowired
    private IJpaGeneralRepository repository;

    @Override
    public Optional<EmployeeSegmentCount> getEmployeeCountBySegmentSalary(Double minSalary, Double maxSalary) {
        return repository.getEmployeeCountBySegmentSalary(minSalary, maxSalary);
    }

    @Override
    public Optional<List<EmployeeSegmentDepartmentCount>> getEmployeeCountBySegmentSalaryGroupByDepartment(Double minSalary, Double maxSalary) {
        return repository.getEmployeeCountBySegmentSalaryGroupByDepartment(minSalary, maxSalary);
    }

    @Override
    public Optional<List<EmployeeInfo>> getEmployeeWithMaxSalaryByDepartment() {
        return repository.getEmployeeWithMaxSalaryByDepartment();
    }

    @Override
    public Optional<List<EmployeeInfo>> getEmployeeByYearsAndJob(Integer years, String job) {
        return repository.getEmployeeByYearsAndJob(years, job);
    }

    @Override
    public Optional<List<DepartmentAvgSalary>> getAverageSalaryByDepartmentEmployeeCount(Integer employees) {
        return repository.getAverageSalaryByDepartmentEmployeeCount(employees);
    }

    @Override
    public Optional<List<BaseCountry>> getCountryReport() {
        return repository.getCountryReport();
    }

}
