/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myhotel.querytest.domain.entities;

import java.time.LocalDate;

/**
 *
 * @author diego
 */
public interface EmployeeInfo {

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhone();

    LocalDate getHireDate();

    Double getSalary();

    String getDepartment();

}
