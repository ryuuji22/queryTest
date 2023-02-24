package com.myhotel.querytest.domain.interfaces.repositories;

import com.myhotel.querytest.domain.entities.BaseCountry;
import com.myhotel.querytest.domain.entities.DepartmentAvgSalary;
import com.myhotel.querytest.domain.entities.EmployeeInfo;
import com.myhotel.querytest.domain.entities.EmployeeSegmentCount;
import com.myhotel.querytest.domain.entities.EmployeeSegmentDepartmentCount;
import java.util.List;
import java.util.Optional;

public interface IGeneralRepository {

    Optional<EmployeeSegmentCount> getEmployeeCountBySegmentSalary(Double minSalary, Double maxSalary);

    Optional<List<EmployeeSegmentDepartmentCount>> getEmployeeCountBySegmentSalaryGroupByDepartment(Double minSalary, Double maxSalary);

    Optional<List<EmployeeInfo>> getEmployeeWithMaxSalaryByDepartment();

    Optional<List<EmployeeInfo>> getEmployeeByYearsAndJob(Integer years, String job);

    Optional<List<DepartmentAvgSalary>> getAverageSalaryByDepartmentEmployeeCount(Integer employees);

    Optional<List<BaseCountry>> getCountryReport();

}
