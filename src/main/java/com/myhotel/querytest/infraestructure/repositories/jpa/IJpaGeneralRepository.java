/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myhotel.querytest.infraestructure.repositories.jpa;

import com.myhotel.querytest.domain.entities.BaseCountry;
import com.myhotel.querytest.domain.entities.BaseEntity;
import com.myhotel.querytest.domain.entities.DepartmentAvgSalary;
import com.myhotel.querytest.domain.entities.EmployeeInfo;
import com.myhotel.querytest.domain.entities.EmployeeSegmentCount;
import com.myhotel.querytest.domain.entities.EmployeeSegmentDepartmentCount;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author diego
 */
public interface IJpaGeneralRepository extends JpaRepository<BaseEntity, Long> {

    //Pregunta 1
    @Query(value = "SELECT count(*) as employeeCount FROM employees where salary >= ?1 AND salary < ?2", nativeQuery = true)
    Optional<EmployeeSegmentCount> getEmployeeCountBySegmentSalary(Double minSalary, Double maxSalary);

    //Pregunta 2
    @Query(value = """
                   SELECT count(e.EMPLOYEE_ID) as employeeCount,d.DEPARTMENT_NAME as department FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID
                   where salary >= ?1 AND salary < ?2
                   GROUP BY d.DEPARTMENT_NAME""", nativeQuery = true)
    Optional<List<EmployeeSegmentDepartmentCount>> getEmployeeCountBySegmentSalaryGroupByDepartment(Double minSalary, Double maxSalary);
    
    //Pregunta 3
    @Query(value = """
                   SELECT 
                   aux2.FIRST_NAME as firstName,
                   aux2.LAST_NAME as lastName,
                   aux2.EMAIL as email,
                   aux2.PHONE_NUMBER as phone,
                   aux2.HIRE_DATE as hireDate,
                   aux2.SALARY as salary,
                   aux2.DEPARTMENT_NAME as department
                   FROM
                   (SELECT 
                          d.DEPARTMENT_NAME,
                          max(e.SALARY) max_salary
                   FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID
                   GROUP BY d.DEPARTMENT_NAME) aux1
                   INNER JOIN 
                   (SELECT e.FIRST_NAME,e.LAST_NAME,e.SALARY,e.EMAIL,e.PHONE_NUMBER,e.HIRE_DATE,d.DEPARTMENT_NAME FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID) aux2
                   on aux1.max_salary=aux2.salary AND aux1.DEPARTMENT_NAME=aux2.DEPARTMENT_NAME""", nativeQuery = true)
    Optional<List<EmployeeInfo>> getEmployeeWithMaxSalaryByDepartment();
    
    //Pregunta 4
    @Query(value = """
                   SELECT e.FIRST_NAME as firstName,
                   e.LAST_NAME as lastName,
                   e.EMAIL as email,
                   e.PHONE_NUMBER as phone,
                   e.HIRE_DATE as hireDate,
                   e.SALARY as salary
                   FROM employees e INNER JOIN jobs j 
                   ON e.JOB_ID=j.JOB_ID WHERE (year(NOW())-year(HIRE_DATE))> :years AND j.JOB_TITLE LIKE CONCAT('%',:job,'%') """, nativeQuery = true)
    Optional<List<EmployeeInfo>> getEmployeeByYearsAndJob(Integer years,String job);
    
    //Pregunta 5
    @Query(value = """
                   SELECT avg(e.SALARY) as avgSalary,d.DEPARTMENT_NAME as department
                   FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID 
                   WHERE d.DEPARTMENT_NAME IN
                   (SELECT aux.DEPARTMENT_NAME FROM
                   (SELECT count(e.EMPLOYEE_ID) as employee_count,d.DEPARTMENT_NAME FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID
                   GROUP BY d.DEPARTMENT_NAME) aux WHERE aux.employee_count > ?1) 
                   GROUP BY d.DEPARTMENT_NAME""", nativeQuery = true)
    Optional<List<DepartmentAvgSalary>> getAverageSalaryByDepartmentEmployeeCount(Integer employees);
    
    //Pregunta 6
    @Query(value = """
                   SELECT 
                   c.COUNTRY_NAME as country,
                   count(e.EMPLOYEE_ID) as employeeCount,
                   avg(e.SALARY) as avgSalary,
                   max(e.SALARY) as maxSalary,
                   min(e.SALARY) as minSalary,
                   avg((year(NOW())-year(HIRE_DATE))) as avgYears
                   FROM employees e 
                   INNER JOIN departments d on e.DEPARTMENT_ID=d.DEPARTMENT_ID
                   INNER JOIN locations l on l.LOCATION_ID=d.LOCATION_ID
                   INNER JOIN countries c on c.COUNTRY_ID=l.COUNTRY_ID
                   GROUP BY c.COUNTRY_NAME""", nativeQuery = true)
    Optional<List<BaseCountry>> getCountryReport();

}
