package com.myhotel.querytest.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadEmployeeDepartmentMaxSalaryQueryHandler implements RequestHandler<ReadEmployeeDepartmentMaxSalaryQuery, Object> {

    @Autowired
    private IGeneralRepository repository;

    @Override
    public Object handle(ReadEmployeeDepartmentMaxSalaryQuery query) {

        var result = repository.getEmployeeWithMaxSalaryByDepartment();
        if (!result.isPresent()) {
            return null;
        }
        return result.get();

    }

}
